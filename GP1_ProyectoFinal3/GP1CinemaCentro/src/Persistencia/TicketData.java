/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Asiento;
import Entidades.Comprador;
import Entidades.Proyeccion;
import Entidades.Sala;
import Entidades.Ticket;
import java.sql.Connection;
import Entidades.conexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author arias
 */
public class TicketData {
    
    private Connection con = null;
    private CompradorData cD = new CompradorData();
    private AsientoData aD = new AsientoData();
    private ProyeccionData pD = new ProyeccionData();
    
    public TicketData (){
    
        con = conexion.getConexion();    
    }
    
    public void generarTicket (Ticket ticket) {
        
        Asiento a = ticket.getAsientoComprado();
        
        if (aD.asientoDisponible(a.getProy().getIdProyeccion(), a.getFila(), a.getNúmero())) {
            
            JOptionPane.showMessageDialog(null, "El asiento seleccionado ya esta ocupado.");
            return;
        }
        
        String sql = "INSERT INTO ticket_compra ( id_lugar , fechaFuncion , fechaCompra , monto , dni) " + "VALUES(?,?,?,?,?)";

        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ticket.getAsientoComprado().getIdAsiento());

            
            ps.setDate(2, java.sql.Date.valueOf(ticket.getFechaCompra()));
            
            ps.setDate(3, java.sql.Date.valueOf(ticket.getFechaFuncion()));
            
            ps.setDouble(4, ticket.getPrecio());
            
            ps.setInt(5, ticket.getComprador().getDni());
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Ticket generado exitosamente.");          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar ticket." + ex.getMessage());
        }
    }

    public Ticket buscarTicket (int idTicket) {
    
        Ticket ticket = null;
        
        String sql = "SELECT * FROM ticket_compra WHERE id_ticket = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTicket);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
                ticket = new Ticket();
                
                ticket.setIdTicket(idTicket);
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getDate("fechaFuncion").toLocalDate());
                ticket.setPrecio(rs.getDouble("monto"));
                
                Comprador c = cD.buscarComprador(rs.getInt("dni"));
                
                ticket.setComprador(c);
                
                Asiento a = aD.buscarAsientoPorId(rs.getInt("id_lugar"));
                
                ticket.setAsientoComprado(a);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el ticket." + ex.getMessage());
        }
        return ticket;
    }
    
    public void modificarFYN (int idTicket, String nuevaFila , int nuevoNumero){
    
        Ticket ticket = buscarTicket(idTicket);
        
        if (ticket == null) {
            
            JOptionPane.showMessageDialog(null , "No existe ese ticket");
            return;
        }
        
        Asiento asientoActual = ticket.getAsientoComprado();
    
        if (asientoActual.getSala() == null) {
            
            JOptionPane.showMessageDialog(null, "El asiento actual no tiene sala asociada");
            return;
        }
        
        int idProy = asientoActual.getProy().getIdProyeccion();
        Asiento asientoNuevo = aD.buscarAsientoProy(idProy, nuevaFila, nuevoNumero);
        
        if (asientoNuevo == null) {
            
            JOptionPane.showMessageDialog(null, "El asiento " + nuevaFila + " " + nuevoNumero+ " no existe en esta Sala.");
            return;
        }
        
        if (!asientoNuevo.isDisponible()) {
            
            JOptionPane.showMessageDialog(null, "El asiento " + nuevaFila + " " + nuevoNumero +  " esta Ocupado");
            return;
        }
        
        String sql = "UPDATE ticket_compra SET id_lugar = ? "
                + "WHERE id_ticket = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, asientoNuevo.getIdAsiento());
            ps.setInt(2, idTicket);
            
            ps.executeUpdate();
            
            
            aD.liberarAsiento(asientoActual.getIdAsiento());
            aD.ocuparAsiento(asientoNuevo.getIdAsiento());
        
            JOptionPane.showMessageDialog(null, "Ticket modificado correctamente.");
            
        } catch (SQLException ex) {
            
           JOptionPane.showMessageDialog(null, "Error al actualizar el ticket." + ex.getMessage());
        }      
    }
    
    public void borrarTicket (int id_ticket){
    
        Ticket ticket = buscarTicket(id_ticket);
        
        if (ticket == null) {
            
            JOptionPane.showMessageDialog(null, "No se encontro el ticket");
            return;
        }
        
        Asiento asiento = ticket.getAsientoComprado();
        
        if (asiento != null) {
            
            aD.liberarAsiento(asiento.getIdAsiento());
        }
        
        String sql = "DELETE FROM ticket_compra WHERE id_ticket = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_ticket);
            
            int exito = ps.executeUpdate();
            
            if (exito > 0 ){
        
                JOptionPane.showMessageDialog(null, "Ticket borrado exitosamente.");
            } else {
            
                JOptionPane.showMessageDialog(null, "No se encontró un ticket con ese ID");
            }
            ps.close();
        
        }catch(SQLIntegrityConstraintViolationException  ex){
            
            JOptionPane.showMessageDialog(null, "No se puede borrar la sala porque tiene proyecciones asociadas.");
        } catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al eliminar la pelicula:" + ex.getMessage());
        }           
    }
    
    public List<Ticket> listarTickets(){
        
        List<Ticket> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM ticket_compra";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Ticket ticket = new Ticket();
                ticket.setIdTicket(rs.getInt("id_ticket"));

                LocalDate fechaC = rs.getDate("fechaCompra").toLocalDate();
                ticket.setFechaCompra(fechaC);
                
                LocalDate fechaF = rs.getDate("fechaFuncion").toLocalDate();
                ticket.setFechaFuncion(fechaF);
                
                ticket.setPrecio(rs.getDouble("monto"));
                
                int idComprador = rs.getInt("dni");
                Comprador comprador = cD.buscarComprador(idComprador);
                ticket.setComprador(comprador);
                
                int idAsiento = rs.getInt("id_lugar");
                Asiento asiento = aD.buscarAsientoPorId(idAsiento);
                ticket.setAsientoComprado(asiento);
                
                lista.add(ticket);
            }
            
            ps.close();
        }catch (SQLException ex){
                    
            JOptionPane.showMessageDialog(null, "Error al listar tickets: " + ex.getMessage());
        }
        
        return lista;
    }
    
    public List<Ticket> buscarTicketsXComp(int dni){
        
        List<Ticket> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM ticket_compra WHERE dni = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
                Ticket ticket = new Ticket();
                
                ticket.setIdTicket(rs.getInt("id_ticket"));
                
                LocalDate fechaC = rs.getDate("fechaCompra").toLocalDate();
                ticket.setFechaCompra(fechaC);
                
                if (rs.getDate("fechaFuncion") != null) {
                             
                    LocalDate fechaF = rs.getDate("fechaFuncion").toLocalDate();
                    ticket.setFechaFuncion(fechaF);
                }
                
                ticket.setPrecio(rs.getDouble("monto"));
                
                int idComprador = rs.getInt("dni");
                Comprador comprador = cD.buscarComprador(idComprador);
                ticket.setComprador(comprador);
                
                int idAsiento = rs.getInt("id_lugar");
                Asiento asiento = aD.buscarAsientoPorId(idAsiento);
                ticket.setAsientoComprado(asiento);
                
                lista.add(ticket);
            }
            ps.close();
            
        }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al buscar tickets del comprador: " + ex.getMessage());
        }
        
        return lista;
    }
    
    public List<Ticket> buscarTicketsXProy(int idProy){
        
        List<Ticket> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM ticket_compra";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProy);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Ticket ticket = new Ticket();
                
                ticket.setIdTicket(rs.getInt("id_ticket"));
                
                LocalDate fechaC = rs.getDate("fechaCompra").toLocalDate();
                ticket.setFechaCompra(fechaC);
                
                if (rs.getDate("fechaFuncion") != null) {
                             
                    LocalDate fechaF = rs.getDate("fechaFuncion").toLocalDate();
                    ticket.setFechaFuncion(fechaF);
                }
                
                ticket.setPrecio(rs.getDouble("monto"));
                
                int idComprador = rs.getInt("dni");
                Comprador comprador = cD.buscarComprador(idComprador);
                ticket.setComprador(comprador);
                
                int idAsiento = rs.getInt("id_lugar");
                Asiento asiento = aD.buscarAsientoPorId(idAsiento);
                ticket.setAsientoComprado(asiento);
                
                if (asiento.getProy() != null && asiento.getProy().getIdProyeccion() == idProy) {
                    
                    lista.add(ticket);
                } 
            }
            
            ps.close();
                      
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al buscar Tickets por Proyeccion. " + ex.getMessage() );
        }
        return lista;
    }
    
    public List<String> obtenerFilas(int idProy){
        
        List<String> filas = new ArrayList<>();
        String sql = "SELECT DISTINCT fila "
                + "FROM asiento "
                + "WHERE id_proyeccion = ? AND estado = 1 "
                + "ORDER BY fila";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProy);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
                filas.add(rs.getString("fila"));
            }
            rs.close();
            ps.close();
            
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR al obtener filas: " + e.getMessage());
        }
        
        return filas;
    }
    
    public List<String> obtenerNumero(int idProy, String fila){
        
        List<String> numeros = new ArrayList<>();
        
        String sql = "SELECT numero "
                    +"FROM asiento "
                    + "WHERE id_proyeccion = ? AND fila = ? AND estado = 1 "
                + "ORDER BY numero";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProy);
            ps.setString(2, fila);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
                numeros.add(String.valueOf(rs.getInt("numero")));
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR al obtene numeros: " + e.getMessage());
        }

        return numeros;
    }
    
}

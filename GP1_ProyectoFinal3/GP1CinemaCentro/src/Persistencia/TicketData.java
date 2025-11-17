/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Asiento;
import Entidades.Comprador;
import Entidades.Ticket;
import java.sql.Connection;
import Entidades.conexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
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
        
        String sql = "SELECT * FROM detalle_ticket WHERE id_ticket = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTicket);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
                ticket = new Ticket();
                
                ticket.setIdTicket(idTicket);
                ticket.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                ticket.setFechaFuncion(rs.getDate("fechaFuncion").toLocalDate());
                ticket.setPrecio(rs.getDouble("precio"));
                
                Comprador c = cD.buscarComprador(rs.getInt("dni"));
                
                ticket.setComprador(c);
                
                Asiento a = aD.buscarAsientoPorId(rs.getInt("id_asiento"));
                
                ticket.setAsientoComprado(a);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el ticket." + ex.getMessage());
        }
        return ticket;
    }
    
    public void actualizarTicket (int idTicket){
    
        String sql = "UPDATE detalle_ticket SET id_ticket = ?, id_proyeccion = ?, cantidad = ?, subtotal = ?, total = ? WHERE codD = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTicket);
            
            int filas = ps.executeUpdate();
            
            if (filas > 0){
            
                JOptionPane.showMessageDialog(null, "Ticket actualizado exitosamente.");
            } else {
            
                JOptionPane.showMessageDialog(null, "No se encontró un ticket con ese código");
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al actualizar el ticket." + ex.getMessage());
        }      
    }
    
    public void borrarTicket (int id_ticket){
    
        String sql = "DELETE FROM ticket_compra WHERE id_ticket = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_ticket);
            
            int exito = ps.executeUpdate();
            
          if (exito == 1){
        
               JOptionPane.showMessageDialog(null, "Ticket borrado exitosamente.");
           } else {
            
               JOptionPane.showMessageDialog(null, "No se encontró un ticket con ese ID");
        }
         ps.close();
        
        }catch (SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al borrar el ticket." + ex.getMessage());
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
    
}

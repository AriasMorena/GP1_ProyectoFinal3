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
            
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(ticket.getFechaFuncion()));

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
                ticket.setFechaCompra(rs.getDate("fechaFuncion").toLocalDate());
                ticket.setFechaFuncion(rs.getTimestamp("fechaFuncion").toLocalDateTime());
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
    
}

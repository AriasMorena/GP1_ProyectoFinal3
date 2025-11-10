/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

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
    
    public TicketData (){
    
        con = conexion.getConexion();    
    }
    
    public void generarTicket (Ticket ticket) {
        
        String sql = "INSERT INTO ticket_ compra tc JOIN detalle_ticket dt ON (dt.codigoVenta, fechaCompra, medioPago, tc.monto)" + "VALUES(?,?,?,?)";

             Date fechaUtil = ticket.getFechaCompra();
         java.sql.Date fechaSql = null;
         
         if (fechaUtil != null) {
            
             fechaSql = new java.sql.Date (fechaUtil.getTime());
        }   
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ticket.getCodigoVenta());
            ps.setDate(2, fechaSql);
            ps.setString(3, ticket.getMedioPago());
            ps.setDouble(4, ticket.getPrecio());
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Ticket generado exitosamente.");          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar ticket." + ex.getMessage());
        }
    }

    public Ticket buscarTicket (int codD) {
    
        Ticket ticket = null;
        
        String sql = "SELECT * FROM detalle_ticket WHERE id_ticket = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codD);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
                ticket = new Ticket();
                
                ticket.setCodigoVenta(rs.getInt("codigoVenta"));
                ticket.setFechaCompra(rs.getDate("fechaCompra"));
                ticket.setMedioPago(rs.getString("medioPago"));
                ticket.setPrecio(rs.getDouble("precio"));
            } else {
            
                JOptionPane.showMessageDialog(null, "No se encontró un ticket con ese código.");
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el ticket." + ex.getMessage());
        }
        return ticket;
    }
    
    public void actualizarTicket (int codD){
    
        String sql = "UPDATE detalle_ticket SET id_ticket = ?, id_proyeccion = ?, cantidad = ?, subtotal = ?, total = ? WHERE codD = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codD);
            
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


package Persistencia;

import Entidades.Comprador;
import Entidades.conexion;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;


/**
 *
 * @author arias
 */
public class CompradorData {
    
    private Connection con= null;
    
    public CompradorData(){
        con = conexion.getConexion();
    }
    
    public void guardarComprador(Comprador comprador){
         String sql = "INSERT INTO comprador (dni, nombre, fechaNac, password, medioDePago) VALUES (?,?,?,?,?) ";
         
              Date fechaUtil = comprador.getFechaNac();
         java.sql.Date fechaSql = null;
         
         if (fechaUtil != null) {
            
             fechaSql = new java.sql.Date (fechaUtil.getTime());
        }
         
         try{
             PreparedStatement ps = con.prepareStatement(sql);

             ps.setInt(1, comprador.getDni());
              ps.setString(2,comprador.getNombre());
              ps.setDate(3, fechaSql);
              ps.setString(4,comprador.getPassword());
              ps.setString(5,comprador.getMedioPago());
              
              ps.executeUpdate();
              ps.close();
              JOptionPane.showMessageDialog(null, "Comprador agregado con éxito");
           }catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al guardar comprador: " + ex.getMessage());
           }
        }
    
    public Comprador buscarComprador(int dni){
        
        Comprador comprador = null;
        
        String sql = "SELECT * FROM comprador WHERE dni =?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,dni);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                
                comprador = new Comprador();
                        
                comprador.setDni(rs.getInt("dni"));
                comprador.setNombre(rs.getString("nombre"));
                comprador.setFechaNac(rs.getDate("fechaNac"));
                comprador.setPassword(rs.getString("password"));
                comprador.setMedioPago(rs.getString("medioDePago"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró comprador con ese DNI.");
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar comprador: " + ex.getMessage());
        }
        return comprador;
    }
    
    
    public List<Comprador> listarCompradores(){
        
        List<Comprador> compradores = new ArrayList<>();
        
        String sql= "SELECT * FROM comprador";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Comprador c = new Comprador ();
                
                c.setDni(rs.getInt("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setFechaNac(rs.getDate("fechaNac"));
                c.setPassword(rs.getString("password"));
                c.setMedioPago(rs.getString("medioDePago"));
                compradores.add(c);   
                
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al listar compradores:" + ex.getMessage());
        }
        return compradores;
    }
    
    public void actualizarComprador(Comprador comprador){
        String sql = "UPDATE comprador SET nombre =?, fechaNac = ?, password =?, medioDePago =? WHERE dni =?";
       
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            Date fechaUtil = comprador.getFechaNac();
            java.sql.Date fechaSql = null;
            
            if (fechaUtil != null) {
                
                fechaSql = new java.sql.Date(fechaUtil.getTime());
            }
            
            ps.setString(1,comprador.getNombre());
            ps.setDate(2, fechaSql);
            ps.setString(3, comprador.getPassword());
            ps.setString(4, comprador.getMedioPago());
            ps.setInt(5, comprador.getDni());
            
            int filas = ps.executeUpdate();
            
            if(filas > 0){
                
                JOptionPane.showMessageDialog(null, "Comprador actualizado con éxito");
                
            } else {
                JOptionPane.showMessageDialog(null,"No se encontro comprador con ese DNI.");
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar comprador:" + ex.getMessage());
        }
    }
    
    public void eliminarComprador(int dni){
        String sql = "DELETE FROM comprador WHERE dni =?";
        try{
            PreparedStatement ps = con.prepareStatement (sql);
            ps.setInt(1,dni);
            int filas = ps.executeUpdate();
            
            if(filas >0){
                JOptionPane.showMessageDialog(null,"Comprardor eliminado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró comprador con ese DNI.");
            }
            ps.close();
        
        } catch(SQLIntegrityConstraintViolationException  ex){
            
            JOptionPane.showMessageDialog(null, "No se puede borrar el comprador porque tiene un ticket asociado.");
        } catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al eliminar la pelicula:" + ex.getMessage());
        }
    }
}

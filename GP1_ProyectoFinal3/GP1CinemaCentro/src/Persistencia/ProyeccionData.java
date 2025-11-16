/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Pelicula;
import Entidades.Proyeccion;
import Entidades.Sala;
import Entidades.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author arias
 */
public class ProyeccionData {
    
   private Connection con = null;
   
   public ProyeccionData (){
       
       con = conexion.getConexion();
   }
    
    public void guardarProyeccion (Proyeccion proyeccion,  int idPeli, int idSala){
       
       String sql = "INSERT INTO proyeccion (id_pelicula, id_sala, idioma, es3D, subtitulada, horaInicio, horaFin, precio, estado)" + "VALUES (?,?,?,?,?,?,?,?,?)";
       
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, idPeli);
           ps.setInt(2, idSala);
           ps.setString(3, proyeccion.getIdioma());
           ps.setBoolean(4, proyeccion.isEs3D());
           ps.setBoolean(5, proyeccion.isSubtitulada());
           ps.setTime(6, proyeccion.getHoraInicio());
           ps.setTime(7, proyeccion.getHoraFin());
           ps.setDouble(8, proyeccion.getPrecioLugar());
           ps.setBoolean(9, proyeccion.isEstado());
           int exito = ps.executeUpdate();
           
           if (exito > 1){
           
           JOptionPane.showMessageDialog(null, "Proyeccion guardada exitosamente.");
           }
           ps.close();
                  
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al guardar la proyeccion." + ex.getMessage());
       }              
   }
    
    public void actualizarProyeccion (Proyeccion proy){
     
        String sql = "UPDATE proyeccion SET id_pelicula = ? , id_sala = ? ,  idioma = ? , es3D = ? ,"
                + " subtitulada = ? , horaInicio = ? , horaFin = ?, precio = ? WHERE id_proyeccion = ? ";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, proy.getPelicula().getIdPelicula());
            ps.setInt(2, proy.getSala().getIdSala());
            ps.setString(3, proy.getIdioma());
            ps.setBoolean(4, proy.isEs3D());
            ps.setBoolean(5, proy.isSubtitulada());
            ps.setTime(6, proy.getHoraInicio());
            ps.setTime(7, proy.getHoraFin());
            ps.setDouble(8, proy.getPrecioLugar());
            ps.setInt(9, proy.getIdProyeccion());
            
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                
                JOptionPane.showMessageDialog(null, "Proyeccion actualizada correctamente.");
            } else {
                
                JOptionPane.showMessageDialog(null, "No se encontro una proyeccion con el ID indicado.");
            }
            
        } catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al actualizar la proyeccion: " + ex.getMessage());
        }
    }
    
    public void borrarProyeccion (int id_proyeccion){
        
        String sql = "DELETE FROM proyeccion WHERE id_proyeccion = ?";
    
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_proyeccion);
        
        int exito = ps.executeUpdate();
        
        if (exito == 1){
        
            JOptionPane.showMessageDialog(null, "Proyeccion borrada exitosamente.");
        } else {
            
            JOptionPane.showMessageDialog(null, "No se encontro una proyeccion con ese ID");
        }
        ps.close();
        
        }catch (SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al borrar la proyeccion." + ex.getMessage());
        }        
    }
    
    public List<Proyeccion>listarProyecciones(){
    
        ArrayList<Proyeccion>Proyecciones = new ArrayList<>();
        
        String sql = "SELECT p.id_proyeccion AS idProyeccion , "
                + "p. id_sala , "
                + "s.NroSala , "
                + "pe.titulo , "
                + "p.idioma , "
                + "p.es3D , "
                + "p.subtitulada , "
                + "p.horaInicio , "
                + "p.horaFin , "
                + "p.precio , "
                + "p.estado "
                + "FROM proyeccion p "
                + "JOIN sala s ON p.id_sala = s.id_Sala "
                + "JOIN pelicula pe ON pe.id_pelicula = p.id_pelicula";
        
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
            
           while (rs.next()) {
             
             Pelicula peli = new Pelicula();
             peli.setTitulo(rs.getString("titulo"));
             
             Sala sala = new Sala();
             sala.setIdSala(rs.getInt("id_sala"));
             sala.setNroSala(rs.getInt("nroSala"));
             
             Proyeccion proy = new Proyeccion ();
             proy.setIdProyeccion(rs.getInt("idProyeccion"));
             proy.setSala(sala);
             proy.setPelicula(peli);
             proy.setIdioma(rs.getString("idioma"));
             proy.setSubtitulada(rs.getBoolean("subtitulada"));
             proy.setEs3D(rs.getBoolean("es3D"));
             proy.setHoraInicio(rs.getTime("horaInicio"));
             proy.setHoraFin(rs.getTime("horaFin"));
             proy.setPrecioLugar(rs.getDouble("precio"));
             proy.setEstado(rs.getBoolean("estado"));
             
             Proyecciones.add(proy);
             
             
           }
           ps.close();
           
       } catch (SQLException ex) {
           
           JOptionPane.showMessageDialog(null, "Error al listar las proyecciones." + ex.getMessage());
           
       }
       return Proyecciones;
    }
    
    public Proyeccion buscarProyeccion (int id_proyeccion) {
    
        Proyeccion proyeccion = null;
        Pelicula peli = null;
        Sala sala = null;
        
         String sql = "SELECT p.id_proyeccion AS idProyeccion , "
                + "s.NroSala , "
                + "pe.titulo , "
                + "p.idioma , "
                + "p.es3D , "
                + "p.subtitulada , "
                + "p.horaInicio , "
                + "p.horaFin , "
                + "p.precio , "
                + "p.estado "
                + "FROM proyeccion p "
                + "JOIN sala s ON p.id_sala = s.id_Sala "
                + "JOIN pelicula pe ON pe.id_pelicula = p.id_pelicula "
                + "WHERE p.id_proyeccion = ? ";
        
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id_proyeccion);
           ResultSet rs = ps.executeQuery();
           
            if (rs.next()){
           
                proyeccion = new Proyeccion ();
                proyeccion.setIdProyeccion(rs.getInt("idProyeccion"));
                
                peli = new Pelicula();
                peli.setTitulo(rs.getString("titulo"));
             
                sala = new Sala();
                sala.setNroSala(rs.getInt("nroSala"));
             

                proyeccion.setSala(sala);
                proyeccion.setPelicula(peli);
                proyeccion.setIdioma(rs.getString("idioma"));
                proyeccion.setSubtitulada(rs.getBoolean("subtitulada"));
                proyeccion.setEs3D(rs.getBoolean("es3D"));
                proyeccion.setHoraInicio(rs.getTime("horaInicio"));
                proyeccion.setHoraFin(rs.getTime("horaFin"));
                proyeccion.setPrecioLugar(rs.getDouble("precio"));
                proyeccion.setEstado(rs.getBoolean("estado"));
             
           }
            ps.close();
           
       } catch (SQLException ex) {
           
           JOptionPane.showMessageDialog(null, "Error al buscar la proyeccion" + ex.getMessage());
       }
       return proyeccion;
    }

    public void darDeAlta (int id){

        int estado = 1;
        String sql = "UPDATE proyeccion SET estado = 1 WHERE id_proyeccion = ?";
        
        try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    
                    ps.setInt(1, id);
                    int filas = ps.executeUpdate();
                    
                    if (filas > 0) {
                        
                        JOptionPane.showMessageDialog(null, "Proyeccion ha sido habilitada");
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "No se encontro una Proyeccion con ese ID.");
                    }
                
            } catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al habilitar la Proyeccion: " + ex);
            }
    }
    
    public void darDeBaja (int id){

        String sql = "UPDATE proyeccion SET estado = ? WHERE id_proyeccion = ?";
        
        try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    
                    ps.setBoolean(1, false);
                    ps.setInt(2, id);
                    
                    
                    
                    int filas = ps.executeUpdate();
                    
                    if (filas > 0) {
                        
                        JOptionPane.showMessageDialog(null, "Proyeccion ha sido dada de baja.");
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "No se encontro una Proyeccion con ese ID.");
                    }
                
            } catch (SQLException ex){
                
                JOptionPane.showMessageDialog(null, "Error al inhabilitar la Proyeccion " + ex);
            }
        
    }    
}

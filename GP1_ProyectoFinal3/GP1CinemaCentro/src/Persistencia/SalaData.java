/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Sala;
import java.sql.Connection;
import Entidades.conexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arias
 */
public class SalaData {
    
    private Connection con = null;
    
    public SalaData (){
    
        con = conexion.getConexion();   
    }
    
    public void crearSala (Sala sala) {
    
        String sql = "INSERT INTO sala (NroSala, apta3D, capacidad, estado)" + "VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sala.getNroSala());
            ps.setBoolean(2, sala.isApta3D());
            ps.setInt(3, sala.getCapacidad());
            ps.setString(4, sala.getEstado());
            int exito =  ps.executeUpdate();
            
            if (exito == 1){
            
            JOptionPane.showMessageDialog(null, "Sala creada correctamente.");       
          }  
            
        } catch (SQLException ex) {
         
            if (ex.getErrorCode() == 1062) {
                
                JOptionPane.showMessageDialog(null, "Ya existe una sala con ese Numero");
            } else {
            
                JOptionPane.showMessageDialog(null, "Error al crear la sala." + ex.getMessage());
            }
        }
}
    
    public Sala buscarSala (int nro){
        
        Sala sala = null;
        
        String sql = "SELECT * FROM sala WHERE id_Sala = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nro);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
                sala = new Sala();
                sala.setIdSala(rs.getInt("id_Sala"));
                sala.setNroSala(rs.getInt("NroSala"));
                sala.setApta3D(rs.getBoolean("apta3D"));
                sala.setCapacidad(rs.getInt("capacidad"));
                sala.setEstado(rs.getString("estado"));
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la sala" + ex.getMessage());
        }
        return sala;
    }
    
    public void borrarSala (int id_sala){
        
        String sql = "DELETE FROM sala WHERE id_sala = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_sala);
            int exito = ps.executeUpdate();
            
            if (exito == 1){
            
                JOptionPane.showMessageDialog(null, "Sala borrada con exito.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar la sala" + ex.getMessage());
        }  
    
    }
    
    public void modificarSala (Sala sala){
        
        String sql = "UPDATE sala SET NroSala = ?, apta3D = ?, capacidad = ?, estado = ? WHERE id_Sala = ?";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sala.getNroSala());
            ps.setBoolean(2, sala.isApta3D());
            ps.setInt(3, sala.getCapacidad());
            ps.setString(4, sala.getEstado());
            ps.setInt(5, sala.getIdSala());
            
            int filas = ps.executeUpdate();
            
            if(filas > 0){
            
                JOptionPane.showMessageDialog(null, "Sala modificada exitosamente.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al modificar la sala." + ex.getMessage());  
        }  
    }
    
        public List<Sala>listarSala(){
      
        List<Sala>listarSalas = new ArrayList<>();
        
        String sql = "SELECT * FROM sala ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                Sala salasCine = new Sala ();
                
                if (true) {
                    
                }
                salasCine.setIdSala(rs.getInt("id_Sala"));
                salasCine.setNroSala(rs.getInt("NroSala"));
                salasCine.setApta3D(rs.getBoolean("apta3D"));
                salasCine.setCapacidad(rs.getInt("capacidad"));
                salasCine.setEstado(rs.getString("estado"));
                listarSalas.add(salasCine);
            }
            ps.close();
        } catch (SQLException ex) {          
            
            JOptionPane.showMessageDialog(null, "Error al listar las salas:" + ex.getMessage());
        }
      return listarSalas;  
    }
      
}


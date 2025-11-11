/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.*;
import Entidades.conexion;
import Persistencia.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author arias
 */
public class AsientoData {
    
        private Connection con = null;
    
    public AsientoData () {
        
        con = conexion.getConexion();   
    }
    
    public void agregarAsiento (Asiento asiento) {
    
        String sql = "INSERT INTO asiento (fila, numero, estado, id_proyeccion, id_sala)" + "VALUES (?, ?, ?, ?, ?)";
    
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, asiento.getFila());
                ps.setInt(2, asiento.getNúmero());
                ps.setBoolean(3, asiento.isDisponible());
                
                if (asiento.getProy() != null) {
                    
                    ps.setInt(4, asiento.getProy().getIdProyeccion());
                } else {
                    
                    ps.setNull(4, java.sql.Types.INTEGER);
                }
                ps.setInt(5, asiento.getSala().getIdSala());
                
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs.next()){
                
                    int id = rs.getInt(1);
                   
                }
                ps.close();
                              
                
            } catch (SQLException e) {
                
               JOptionPane.showMessageDialog(null,"Error al agregar el asiento." + e.getMessage());
            }
    }
    
    public void generarAsientos (Sala sala, Proyeccion proyeccion){
        
        int capacidad = sala.getCapacidad();
        int asientosPorFila = 10;
        int filas = (int) Math.ceil((double) capacidad / asientosPorFila);
        
        char letraFila = 'A';
        int contador = 0;
        
        for (int f = 0; f < filas; f++) {
            
            for (int n = 1; n <= asientosPorFila; n++) {
                
                if (contador >= capacidad) {
                    
                    break;
                } else {
                    
                    Asiento asiento = new Asiento (String.valueOf(letraFila), n, true, proyeccion, sala);
                    agregarAsiento(asiento);
                    contador++;
                }
            }
        letraFila++;

        }
        
        JOptionPane.showMessageDialog(null, "Se generaron " + contador + " asiento para la sala " + sala.getNroSala());
    }
    
    public boolean existeAsiento (String fila, int numero , int idSala){
        
        String sql = "SELECT 1 FROM asiento WHERE fila = ? AND numero = ? AND id_sala = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, fila);
            ps.setInt(2, numero);
            ps.setInt(3, idSala);
            
            ResultSet rs= ps.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR al verificar asientos: " + e.getMessage());
        }
        return false;
    } 
    
    public void modificarAsiento (Asiento asiento){
    
        String sql = "UPDATE asiento SET fila = ?, numero = ?, estado = ?, id_proyeccion = ?, id_sala WHERE id_lugar = ?";
        
            try {
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, asiento.getFila());
                ps.setInt(2, asiento.getNúmero());
                ps.setBoolean(3, asiento.isDisponible());
                ps.setInt(4, asiento.getProy().getIdProyeccion());
                ps.setInt(5, asiento.getSala().getIdSala());
                ps.setInt(6, asiento.getIdAsiento());
                int filas = ps.executeUpdate();
                
                if(filas > 0){
                
                    JOptionPane.showMessageDialog(null, "Asiento modificado exitosamente.");    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "No se encontro un asiento con ese ID.");
                }
                
                ps.close();
                
            } catch (SQLException ex) {
               
                JOptionPane.showMessageDialog(null, "Error al modificar el asiento" + ex.getMessage());
            }  
    }
    
    public Asiento buscarAsiento (int id_lugar) {
        
        ProyeccionData pd= new ProyeccionData();
        SalaData sd = new SalaData();
    
        Asiento asiento = null;
        
        String sql = "SELECT * FROM asiento WHERE id_lugar = ?";
        
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_lugar);
        ResultSet rs = ps.executeQuery();
                
        if (rs.next()){
        
            asiento = new Asiento();
       
            asiento.setIdAsiento(rs.getInt("id_asiento"));
            asiento.setFila(rs.getString("fila"));
            asiento.setNúmero(rs.getInt("numero"));
            asiento.setDisponible(rs.getBoolean("estado"));
            
            Proyeccion proy = pd.buscarProyeccion(rs.getInt("id_proyeccion"));
            Sala sala = sd.buscarSala(rs.getInt("id_sala"));
            
            asiento.setProy(proy);
            asiento.setSala(sala); 
        }
           ps.close();
           
        } catch (SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al buscar el asiento." + ex.getMessage());
        }
       return asiento;
    }
    
    public void borrarAsiento (int id_lugar){
    
        String sql = "DELETE FROM asiento WHERE id_lugar = ?";
        
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id_lugar);
                int exito = ps.executeUpdate();
                
                if (exito == 1){
                    
                  JOptionPane.showMessageDialog(null, "Asiento borrado exitosamente.");
                
                }          
            } catch (SQLException ex) {
               
                JOptionPane.showMessageDialog(null, "Error al borrar el asiento." + ex.getMessage());
            }
    }
    
    public List<Asiento>listarAsientos(){
        
        List<Asiento>listarAsientos = new ArrayList<>();
    
        String sql = "SELECT * FROM asiento ";
        
        ProyeccionData pd= new ProyeccionData();
        SalaData sd = new SalaData();
    
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()){
                
                    Asiento asientos = new Asiento();
               
                    asientos.setIdAsiento(rs.getInt("id_asiento"));
                    asientos.setFila(rs.getString("fila"));
                    asientos.setNúmero(rs.getInt("numero"));
                    asientos.setDisponible(rs.getBoolean("estado"));
                    
                    asientos.setProy(pd.buscarProyeccion(rs.getInt("id_proyeccion")));
                    asientos.setSala(sd.buscarSala(rs.getInt("id_sala")));           
                    
                    listarAsientos.add(asientos);
                
                }
                ps.close();
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Error al listar las salas." + ex.getMessage());
            }
          return listarAsientos;
    }


public List<String> obtenerFilas (int idSala){
    
    List<String> filas = new ArrayList<>();

    String sql = "SELECT DISTINCT fila FROM asiento WHERE id_sala = ? ORDER BY fila";

    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idSala);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            filas.add(rs.getString("fila"));
        }
        
        rs.close();
        ps.close();
    } catch (SQLException x){
        
        JOptionPane.showMessageDialog(null, "ERROR al obtener filas: " + x.getMessage());
    }
    return filas;
}

public List<String> obtenerNumeros (String fila, int idSala){
    List<String> numeros = new ArrayList<>();
    String sql = "SELECT numero, estado FROM asiento WHERE id_sala = ? AND fila = ? ORDER BY numero ";
    
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, idSala);
        ps.setString(2, fila);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            int numero = rs.getInt("numero");
            boolean disponible = rs.getBoolean("estado");
            
            if (disponible) {
                
                numeros.add(numero + " ✅");
            } else {
                
                numeros.add(numero + " ❌");
            }
        }
        
        rs.close();
        ps.close();
        
    }catch (SQLException x){
        
        JOptionPane.showMessageDialog(null, "ERROR al obtener asientos: " + x.getMessage());
    }
    return numeros;
    }


}

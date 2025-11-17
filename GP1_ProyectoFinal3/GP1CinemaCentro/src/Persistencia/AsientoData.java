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
    
    // ------------ Agregar y Generar Asientos ------------
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
    
    public boolean existeAsiento ( int idSala){
        
        String sql = "SELECT 1 FROM asiento WHERE id_sala = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setInt(1, idSala);
            
            ResultSet rs= ps.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR al verificar asientos: " + e.getMessage());
        }
        return false;
    } 
    // ------------ Buscar Asiento ------------
    
    public Asiento buscarAsiento (int idSala, String fila, int numero) {
        
        String sql = "SELECT * FROM asiento WHERE fila = ? AND numero = ? AND id_sala = ? ";
        
        ProyeccionData pd= new ProyeccionData();
        
        SalaData sd = new SalaData();
    
        Asiento asiento = null;        
       
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, fila);
        ps.setInt(2, numero);
        ps.setInt(3, idSala);
        
        ResultSet rs = ps.executeQuery();
                
        if (rs.next()){
        
            asiento = new Asiento();
       
            asiento.setIdAsiento(rs.getInt("id_lugar"));
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
    // ------------ Elimar Asientos ------------
    public void borrarAsientoPorSala (int idSala){
    
        String sql = "DELETE FROM asiento WHERE id_sala = ?";
        
        SalaData sd = new SalaData ();
        
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idSala);
                
                int fila = ps.executeUpdate();
                
                if (fila < 0){
                    
                  JOptionPane.showMessageDialog(null, "Se eliminaron " + fila + " asientos de la sala Numero " + sd.buscarSala(idSala).getNroSala());
                
                }          
            } catch (SQLException ex) {
               
                JOptionPane.showMessageDialog(null, "Error al borrar los asientos." + ex.getMessage());
            }
    }
    
    // ------------ Mostrar Todos los Asientos de una Sala ------------
    public List<Asiento>listarAsientos(int idSala){
        
        List<Asiento>listarAsientos = new ArrayList<>();
    
        String sql = "SELECT * FROM asiento WHERE id_sala = ? ORDER BY fila , numero ";
        
        ProyeccionData pd= new ProyeccionData();
        SalaData sd = new SalaData();
    
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, idSala);

                ResultSet rs = ps.executeQuery();                
                
                while (rs.next()){
                
                    Asiento asientos = new Asiento();
               
                    asientos.setIdAsiento(rs.getInt("id_lugar"));
                    asientos.setFila(rs.getString("fila"));
                    asientos.setNúmero(rs.getInt("numero"));
                    asientos.setDisponible(rs.getBoolean("estado"));
                    
                    int idProy = rs.getInt("id_proyeccion");
                    int idSalaB = rs.getInt("id_sala");
                    
                    asientos.setProy(pd.buscarProyeccion(idProy));
                    asientos.setSala(sd.buscarSala(idSalaB));
                       
                    listarAsientos.add(asientos);
                
                }
                ps.close();
                
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Error al listar las salas." + ex.getMessage());
            }
            
          return listarAsientos;
    }
    // ------------ Ocupar y Liberar Asientos ------------
    
    public void ocuparAsiento(int idAs){
        
        String sql = "UPDATE asiento SET estado = false WHERE  id_lugar = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAs);
            
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                
                JOptionPane.showMessageDialog(null, "Asiento Ocupado");
            } else {
                
                JOptionPane.showMessageDialog(null, "No se encontro el asiento marcado.");
            }
        }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al ocupar el asiento: " + ex.getMessage());
        }
       
    }
    
    public void liberarAsiento(int idAs){
        
        String sql = "UPDATE asiento SET estado = true WHERE  id_lugar = ?";
        
            try{
                PreparedStatement ps = con.prepareStatement(sql);
            
                ps.setInt(1, idAs);
            
                int filas = ps.executeUpdate();
            
                if (filas > 0) {
                
                    JOptionPane.showMessageDialog(null, "Asiento liberado");
                } else {
                
                    JOptionPane.showMessageDialog(null, "No se encontro el asiento marcado.");
                }
            }catch (SQLException ex){
            
                JOptionPane.showMessageDialog(null, "Error al liberar el asiento: " + ex.getMessage());
            }
        
    }
    
    // ------------ ComboBox Filas y Numeros ------------
    
    
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

    public Asiento buscarAsientoPorId(int idAsiento){
        
        Asiento asiento = null;
        
        String sql = "SELECT a.* , p.* , pe.titulo , s.nroSala "
                + "FROM asiento a "
                + "JOIN proyeccion p ON a.id_proyeccion = p.id_proyeccion "
                + "JOIN sala s ON p.id_sala = s.id_sala "
                + "JOIN pelicula pe ON p.id_pelicula = pe.id_pelicula "
                + " WHERE a.id_lugar = ? ";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAsiento);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                asiento = new Asiento ();
                asiento.setIdAsiento(rs.getInt("id_lugar"));
                asiento.setFila(rs.getString("fila"));
                asiento.setNúmero(rs.getInt("numero"));

                asiento.setDisponible(rs.getBoolean("estado"));
                
                Sala s = new Sala();
                s.setIdSala(rs.getInt("id_sala"));
                s.setNroSala(rs.getInt("nroSala"));
                
                Pelicula peli = new Pelicula();
                peli.setIdPelicula(rs.getInt("id_pelicula"));
                peli.setTitulo(rs.getString("titulo"));
                
                Proyeccion proy = new Proyeccion ();
                proy.setIdProyeccion(rs.getInt("id_proyeccion"));
                proy.setSala(s);
                proy.setPelicula(peli);
                proy.setHoraInicio(rs.getTime("horaInicio"));
                proy.setHoraFin(rs.getTime("horaFin"));
                proy.setPrecioLugar(rs.getDouble("precio"));
                
                asiento.setSala(s);
                
                asiento.setProy(proy);
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR: Al buscar Asiento: " + e.getMessage());
        }
        
        return asiento;
    }
    
    public boolean asientoDisponible(int idLugar){
        
        String sql = "SELECT estado FROM asiento WHERE id_lugar = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLugar);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                return rs.getBoolean("estado");
            }
        } catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro al verificar asiento: " + ex.getMessage());
        }
        
        return false;
    }


}

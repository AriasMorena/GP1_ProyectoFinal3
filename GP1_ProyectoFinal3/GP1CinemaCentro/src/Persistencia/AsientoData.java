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
    
        String sql = "INSERT INTO asiento (fila, numero, estado, id_proyeccion , id_sala)"
                    + " VALUES( ?, ?, ?, ?, ?)";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, asiento.getFila());
                ps.setInt(2, asiento.getNúmero());
                ps.setBoolean(3, asiento.isDisponible());
                ps.setInt(4, asiento.getProy().getIdProyeccion());
                ps.setInt(5, asiento.getSala().getIdSala());
                
                ps.executeUpdate();
                ps.close();
                
            } catch (SQLException e) {
                
               JOptionPane.showMessageDialog(null,"Error al agregar el asiento." + e.getMessage());
            }
        
    }
    
    public void generarAsientos (Sala sala, Proyeccion proyeccion){
        
        if (existeAsientoProy(proyeccion.getIdProyeccion())) {
            
            JOptionPane.showMessageDialog(null, "Esta proyeccion ya tiene asientos generados.");
            return;
        }
        
        int capacidad = sala.getCapacidad();
        int asientosPorFila = 10;
        
        int filas = (int) Math.ceil((double) capacidad / asientosPorFila);
        
        char letraFila = 'A';
        int contador = 0;

        
        for (int f = 0; f < filas; f++) {
            

            for (int n = 1; n <= asientosPorFila; n++) {
                                
                if (contador >= capacidad) {
                    JOptionPane.showMessageDialog(null, "Se ocuparon todos los lugars");
                    break;
                } 
                   
                Asiento asiento = new Asiento (String.valueOf(letraFila), n, true, proyeccion, sala);
                
                agregarAsiento(asiento);
                contador = contador +1;
            }
            
         letraFila++;

        }
        
        JOptionPane.showMessageDialog(null, "Se generaron " + contador + " asiento para la proyeccion" + proyeccion.getIdProyeccion());
    } 
    
    public boolean existeAsientoProy (int idProyeccion){
        
        String sql = "SELECT 1 FROM asiento WHERE id_proyeccion = ? LIMIT 1 ";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProyeccion);
            
            ResultSet rs = ps.executeQuery();
            boolean existe = rs.next();
            
            rs.close();
            ps.close();
                  
            return existe;

        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "ERROR al verificar asientos: " +e);
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
    public void borrarAsientoPorProyeccion (int idProy){
    
        String sql = "DELETE FROM asiento WHERE id_proyeccion = ?";
        
        SalaData sd = new SalaData ();
        ProyeccionData pd = new ProyeccionData();
        
        Proyeccion proy = pd.buscarProyeccion(idProy);
        
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idProy);
                
                int fila = ps.executeUpdate();
                
                if (fila < 0){
                    
                  JOptionPane.showMessageDialog(null, "Se eliminaron " + fila + " asientos de la sala Numero " + proy.getSala().getNroSala()  );
                
                }          
            } catch (SQLException ex) {
               
                JOptionPane.showMessageDialog(null, "Error al borrar los asientos." + ex.getMessage());
            }
    }
    
    // ------------ Mostrar Todos los Asientos de una Sala ------------
    public List<Asiento>listarAsientos(int idProy){
        
        List<Asiento>listarAsientos = new ArrayList<>();
    
        String sql = "SELECT * FROM asiento WHERE id_proyeccion = ? ORDER BY fila , numero ";
        
        ProyeccionData pd= new ProyeccionData();
        SalaData sd = new SalaData();
    
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, idProy);

                ResultSet rs = ps.executeQuery();                
                
                while (rs.next()){
                
                    Asiento asientos = new Asiento();
               
                    asientos.setIdAsiento(rs.getInt("id_lugar"));
                    asientos.setFila(rs.getString("fila"));
                    asientos.setNúmero(rs.getInt("numero"));
                    asientos.setDisponible(rs.getBoolean("estado"));
                    
                    int idSala = rs.getInt("id_sala");
                    asientos.setSala(sd.buscarSala(idSala));
                    
                    asientos.setProy(pd.buscarProyeccion(idProy));

                    
                    listarAsientos.add(asientos);
                
                }
                ps.close();
                rs.close();
                
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
    
    
public List<String> obtenerFilas (int idProye){
    
    List<String> filas = new ArrayList<>();

    String sql = "SELECT DISTINCT fila FROM asiento WHERE id_proyeccion = ? ORDER BY fila";

    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idProye);
        
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

public List<String> obtenerNumeros (int idProye, String fila){
    List<String> numeros = new ArrayList<>();
    String sql = "SELECT numero, estado FROM asiento WHERE id_proyeccion = ? AND fila = ? ORDER BY numero ";
    
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, idProye);
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
    
    public boolean asientoDisponible(int idProyeccion, String fila, int numero){
        
        String sql = "SELECT estado FROM asiento "
                + "WHERE id_proyeccion = ? AND fila = ? AND numero = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProyeccion);
            ps.setString(2, fila);
            ps.setInt(3, numero);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                return !rs.getBoolean("estado");
            }
        } catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro al verificar asiento: " + ex.getMessage());
        }
        
        return false;
    }
    
    public Asiento buscarAsientoProy (int idProy,  String fila, int numero){
        
        String sql = "SELECT * FROM asiento WHERE id_proyeccion = ? AND fila = ? AND numero = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProy);
            ps.setString(2, fila);
            ps.setInt(3, numero);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                Asiento a = new Asiento();
                a.setIdAsiento(rs.getInt("id_lugar"));
                a.setFila(rs.getString("fila"));
                a.setNúmero(rs.getInt("numero"));
                a.setDisponible(rs.getBoolean("estado"));
                
                ProyeccionData pd = new ProyeccionData();
                a.setProy(pd.buscarProyeccion(idProy));
                
                SalaData sd = new SalaData();
                a.setSala(sd.buscarSala(rs.getInt("id_sala")));
                
                return a;
            }
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al buscar asiento: " + e.getMessage());
        }
        return null;
    }
    
    
}

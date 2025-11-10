/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author arias
 */
public class conexion {
    
    
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String BD = "cinemacentro";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private conexion() {}        

     public static Connection getConexion() {
        Connection con = null;
    
    try {
    
        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(URL + BD, USUARIO, PASSWORD);
    
    }catch (ClassNotFoundException e){
        
        JOptionPane.showMessageDialog(null, "Error al conectar el Driver");
    
    }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error al conectar la BD " + e);
    }
    return con;
    }
}

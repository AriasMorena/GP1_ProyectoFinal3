/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Entidades.*;
import Persistencia.PeliculaData;
import java.util.Date;
import java.util.List;


/**
 *
 * @author arias
 */
public class Main {
    
    public static void main (String[] args) {
        
        
        PeliculaData peliculaD = new PeliculaData();
        
        //Agregando Pelicula
        
        Pelicula p1 = new Pelicula();
        
        p1.setTitulo("Proyecto Final");
        p1.setDirector("Profes");
        p1.setActores("Morena Arias, Lucio Ponce, Guada Bustos");
        p1.setOrigen("Argentina");
        p1.setGenero("Ciencia Ficcion");
        p1.setEstreno(new Date());
        p1.setEnCartelera(true);
        
        peliculaD.guardarPelicula(p1);
        
        //Buscar Pelicula
        
        Pelicula encontrada = peliculaD.buscarPelicula(1);
        if (encontrada != null) {
            
            System.out.println("Pelicula encontrada: " + encontrada.getTitulo());
        }
        
        //Modificar Pelicula
        
        if (encontrada != null) {
            
            encontrada.setGenero("Suspenso / Terror");
            
            peliculaD.modificarPelicula(encontrada);
            
        }
        
        //Listar Peliculas
        
        List<Pelicula> lista = peliculaD.listarPeliculas();
        
        for (Pelicula peli: lista) {
            
            System.out.println(peli.getTitulo() + " - " + peli.getGenero());
        }
        
        //Eliminar Pelicula
        
        peliculaD.eliminarPelicula(10);
    }
}

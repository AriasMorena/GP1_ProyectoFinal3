
package Entidades;

import java.util.Date;
/**
 *
 * @author Bustos Guada
 */
public class Comprador {
    
    private int dni;
    private String nombre;
    private Date fechaNac;
    private String password;
    private String medioPago;

    public Comprador(int dni, String nombre, Date fechaNac, String password, String medioPago) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.password = password;
        this.medioPago = medioPago;
    }

    public Comprador() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    
    public void comprarTicket(){
        System.out.println(nombre + "ha comprado un ticket usando" + medioPago + ".");
    }
    
    public void verHistorialCompras(){
        System.out.println("Mostrando historial de compras para " + nombre + "(DNI: " + dni + ").");
    }
    
    @Override
    public String toString (){
        return "Comprador{" + 
                "dni=" + dni +
                ", nombre=" + nombre + 
                ", fechaNac=" + fechaNac +
                ", password="  + password +
                ", medioPago=" + medioPago + 
                "}";   
                
    }
}

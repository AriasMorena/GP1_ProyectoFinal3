
package Entidades;

import Entidades.Comprador;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author Bustos Guada
 */
public class Ticket {
    
    private int idTicket;
    private LocalDate fechaCompra;
    private LocalDate fechaFuncion;
    private double precio;
    
    private Comprador comprador;
    private Asiento asientoComprado;

    public Ticket(int idTicket, LocalDate fechaCompra, LocalDate fechaFuncion, double precio, Comprador comprador, Asiento asientoComprado) {
        this.idTicket = idTicket;
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.precio = precio;
        this.comprador = comprador;
        this.asientoComprado = asientoComprado;
    }

    
    
    public Ticket() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDate getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(LocalDate fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Asiento getAsientoComprado() {
        return asientoComprado;
    }

    public void setAsientoComprado(Asiento asientoComprado) {
        this.asientoComprado = asientoComprado;
    }
    
    

    
    
    public void imprimirTicket(){
        System.out.println("------------------TICKET------------------");
        
        System.out.println("Código de venta: " + idTicket);
        System.out.println("Fecha de compra: " + fechaCompra);
        System.out.println("Fecha de Funcion: " + fechaFuncion);
        System.out.println("Precio: $" + precio);
        
        System.out.println("------------------------------------------");
        
    }
    
    @Override
    public String toString(){
        return "Ticket{" +
                "codigoVenta=" + idTicket +
                ", fechaCompra=" + fechaCompra +
                ", fechaFuncion="  + fechaFuncion +
                ", precio=" + precio +
                "}";
    }
}

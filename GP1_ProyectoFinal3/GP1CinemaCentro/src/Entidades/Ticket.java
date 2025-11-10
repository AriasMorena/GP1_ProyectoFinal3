
package Entidades;

import java.util.Date;
/**
 *
 * @author Bustos Guada
 */
public class Ticket {
    
    private int codigoVenta;
    private Date fechaCompra;
    private String medioPago;
    private double precio;
    private Proyeccion proyeccion;

    public Ticket(int codigoVenta, Date fechaCompra, String medioPago, double precio, Proyeccion proyeccion) {
        this.codigoVenta = codigoVenta;
        this.fechaCompra = fechaCompra;
        this.medioPago = medioPago;
        this.precio = precio;
        this.proyeccion = proyeccion;
    }

    public Ticket() {
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }
    
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void imprimirTicket(){
        System.out.println("------------------TICKET------------------");
        
        System.out.println("Código de venta: " + codigoVenta);
        System.out.println("Fecha de compra: " + fechaCompra);
        System.out.println("Medio de pago: " + medioPago);
        System.out.println("Precio: $" + precio);
        
        System.out.println("------------------------------------------");
        
    }
    
    public void validarTicket(){
        if(codigoVenta <= 0){
            System.out.println("Código de venta inválido.");
        }else if (fechaCompra == null){
            System.out.println("Fecha de4 compra no asignada.");
        }else if (medioPago == null || medioPago.isEmpty()){
            System.out.println("Medio de pago no especificado.");
        }else if(precio <= 0){
            System.out.println("Precio inválido.");
        }else{
            System.out.println("Ticket válido.");
        }
    } 
    
    @Override
    public String toString(){
        return "Ticket{" +
                "codigoVenta=" + codigoVenta +
                ", fechaCompra=" + fechaCompra +
                ", medioPago="  + medioPago +
                ", precio=" + precio +
                "}";
    }
}

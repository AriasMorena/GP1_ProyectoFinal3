
package Entidades;

import java.util.Date;
import Entidades.Comprador;
/**
 *
 * @author Bustos Guada
 */
public class Ticket {
    
    private int idTicket;
    private Date fechaCompra;
    private String medioPago;
    private double precio;
    private Comprador comprador;

    public Ticket(int idTicket, Date fechaCompra, String medioPago, double precio, Comprador comprador) {
        this.idTicket = idTicket;
        this.fechaCompra = fechaCompra;
        this.medioPago = medioPago;
        this.precio = precio;
        this.comprador = comprador;
    }

    public Ticket() {
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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
        
        System.out.println("Código de venta: " + idTicket);
        System.out.println("Fecha de compra: " + fechaCompra);
        System.out.println("Medio de pago: " + medioPago);
        System.out.println("Precio: $" + precio);
        
        System.out.println("------------------------------------------");
        
    }
    
    public void validarTicket(){
        if(idTicket <= 0){
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
                "codigoVenta=" + idTicket +
                ", fechaCompra=" + fechaCompra +
                ", medioPago="  + medioPago +
                ", precio=" + precio +
                "}";
    }
}

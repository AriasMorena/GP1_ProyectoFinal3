
package Entidades;

/**
 *
 * @author lucio
 */
public class CompraTicket {
    
    private int codD;
    private int idTicket;
    private Proyeccion proyeccion;
    private Asiento asiento;
    private int cantidad;
    private double subtotal;
    private double total;

    public CompraTicket(int codD, int idTicket, Proyeccion proyeccion, Asiento asiento, int cantidad, double subtotal, double total) {
        this.codD = codD;
        this.idTicket = idTicket;
        this.proyeccion = proyeccion;
        this.asiento = asiento;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getCodD() {
        return codD;
    }

    public void setCodD(int codD) {
        this.codD = codD;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    



}

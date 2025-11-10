
package Entidades;

/**
 *
 * @author Bustos Guada
 */
public class Asiento {
    
    private String fila;
    private int número;
    private boolean disponible;
    private Proyeccion proy ;
    private Sala sala;
    private int idAsiento;

    public Asiento(String fila, int número, boolean disponible, Proyeccion proy, Sala sala) {
        this.fila = fila;
        this.número = número;
        this.disponible = disponible;
        this.proy = proy;
        this.sala = sala;
    }

    public Asiento() {
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }
    
    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        this.número = número;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Proyeccion getProy() {
        return proy;
    }

    public void setProy(Proyeccion proy) {
        this.proy = proy;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }      
}

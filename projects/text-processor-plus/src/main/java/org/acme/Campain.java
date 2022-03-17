package org.acme;

public class Campain {

    private String nombre;
    private int fecha;
    
    public Campain() {

    }

    public Campain(String nombre, int fecha) {
        super();
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFecha() {
        return fecha;
    }
}

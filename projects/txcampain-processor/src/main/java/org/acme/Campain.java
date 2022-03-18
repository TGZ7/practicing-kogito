package org.acme;

public class Campain {

    private String nombre;
    private int fecha;
    private int likes;
    private int dislikes;
    private int interacciones;
    private Boolean exitosa;
    
    public Campain() {

    }

    public Campain(String nombre, int fecha, int likes, int dislikes, int interacciones) {
        super();
        this.nombre = nombre;
        this.fecha = fecha;
        this.likes = likes;
        this.dislikes = dislikes;
        this.interacciones = interacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFecha() {
        return fecha;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getInteracciones() {
        return interacciones;
    }

    public Boolean getExitosa() {
        return exitosa;
    }

    public void setExitosa(Boolean exitosa) {
        this.exitosa = exitosa;
    }
}

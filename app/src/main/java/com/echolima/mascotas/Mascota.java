package com.echolima.mascotas;

/**
 * Created by Fernando on 04/09/2016.
 */
public class Mascota {

    private int id;
    private int foto;
    private String nombre;
    private int rate;  // hemos cambiado String por int para el metodo suma de onbindviewholder de MascotaAdaptador y FavoritoAdaptador

    public Mascota (int foto, String nombre, int rate){
        this.foto = foto;
        this.nombre = nombre;
        this.rate = rate;
    }

    public Mascota() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


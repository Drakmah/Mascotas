package com.echolima.mascotas;

/**
 * Created by Fernando on 04/09/2016.
 */
public class Mascota {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int rate;  // hemos cambiado String por int para el metodo suma de onbindviewholder de MascotaAdaptador y FavoritoAdaptador

    public Mascota (String urlFoto, String nombreCompleto, int rate){
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.rate = rate;
    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}


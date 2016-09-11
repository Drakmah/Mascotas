package com.echolima.mascotas;

/**
 * Created by Fernando on 11/09/2016.
 */
public class MascotaGrid {

    private int foto;
    private String rate;

    public MascotaGrid (int foto, String rate){
        this.foto = foto;
        this.rate = rate;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}



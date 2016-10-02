package com.echolima.mascotas.restApi.model;

import com.echolima.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by Fernando on 01/10/2016.
 */

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}

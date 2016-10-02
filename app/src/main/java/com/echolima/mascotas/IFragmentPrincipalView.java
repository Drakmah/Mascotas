package com.echolima.mascotas;

import java.util.ArrayList;

/**
 * Created by Fernando on 16/09/2016.
 */
public interface IFragmentPrincipalView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}

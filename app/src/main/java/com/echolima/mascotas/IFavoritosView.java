package com.echolima.mascotas;

import java.util.ArrayList;

/**
 * Created by Fernando on 17/09/2016.
 */
public interface IFavoritosView {

    public void generarLinearLayoutVertical();

    public FavoritoAdaptador crearAdaptador(ArrayList<Mascota> favoritos);

    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador);
}

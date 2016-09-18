package com.echolima.mascotas.presentador;

import android.content.Context;

import com.echolima.mascotas.IFavoritosView;
import com.echolima.mascotas.Mascota;
import com.echolima.mascotas.db.ConstructorMascotasFav;

import java.util.ArrayList;

/**
 * Created by Fernando on 17/09/2016.
 */
public class FavoritosPresenter implements IFavoritosPresenter {

    private IFavoritosView iFavoritosView;
    private Context context;
    private ConstructorMascotasFav constructorMascotasFav;
    private ArrayList<Mascota> favoritos;

    public FavoritosPresenter(IFavoritosView iFavoritosView, Context context) {
        this.iFavoritosView = iFavoritosView;
        this.context = context;
        obtenerFavoritosBaseDatos();

    }

    @Override
    public void obtenerFavoritosBaseDatos() {

        constructorMascotasFav = new ConstructorMascotasFav(context);
        favoritos = constructorMascotasFav.obtenerDatos();
        mostrarFavoritosRV();

    }

    @Override
    public void mostrarFavoritosRV() {

        iFavoritosView.inicializarAdaptadorRV(iFavoritosView.crearAdaptador(favoritos));
        iFavoritosView.generarLinearLayoutVertical();

    }
}

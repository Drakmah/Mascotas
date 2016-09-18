package com.echolima.mascotas.db;

import android.content.Context;

import com.echolima.mascotas.Mascota;
import com.echolima.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Fernando on 17/09/2016.
 */
public class ConstructorMascotasFav {

    Context context;

    public ConstructorMascotasFav(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        // Aqui es de donde obtenemos los datos , ya sean hardcodeados, de una BBDD, de un webservice...
        //-----------------------------------------------------------------------------------------------

        /*ArrayList<Mascota> favoritos = new ArrayList<>();
        favoritos.add(new Mascota(R.drawable.dog05, "Nina", 1)); // he cambiado los rates de string a int para el metodo suma de MascotaAdaptador y FavoritoAdaptador
        favoritos.add(new Mascota(R.drawable.dog01, "Bobby", 1));
        favoritos.add(new Mascota(R.drawable.dog03, "Yoyo", 1));
        favoritos.add(new Mascota(R.drawable.dog02, "Frey", 1));
        favoritos.add(new Mascota(R.drawable.dog04, "Arly", 1));
        return favoritos;*/


        BaseDatos db = new BaseDatos(context);
        return db.obtenerfavoritas();



    }
}

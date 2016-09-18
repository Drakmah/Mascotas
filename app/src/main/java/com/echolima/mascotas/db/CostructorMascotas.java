package com.echolima.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.echolima.mascotas.Mascota;
import com.echolima.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Fernando on 16/09/2016.
 */
public class CostructorMascotas {

    private static final int LIKE = 1;
    Context context;
   // static boolean bandera = false;

    public CostructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){


        // Aqui es de donde obtenemos los datos , ya sean hardcodeados, de una BBDD, de un webservice...
        //-----------------------------------------------------------------------------------------------
        /*ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.dog01, "Bobby", 8)); // he cambiado los rates de string a int para el metodo suma de MascotaAdaptador y FavoritoAdaptador
        mascotas.add(new Mascota(R.drawable.dog02, "Frey", 4));
        mascotas.add(new Mascota(R.drawable.dog03, "Yoyo", 3));
        mascotas.add(new Mascota(R.drawable.dog04, "Arly", 9));
        mascotas.add(new Mascota(R.drawable.dog05, "Nina", 10));
        return mascotas;*/

        // ***********************************************************
        //************************************************************
        // CADA VEZ QUE SE CARGA LA PANTALLA PRINCIPAL SE AÑADEN SEIS MASCOTAS
        //************************************************************
        //************************************************************
        BaseDatos db = new BaseDatos(context); // Creamos el objeto BaseDatos db-----------
        //if (this.bandera == false) {
        if (db.recuentodatos() == 0){
            insertarSeisMascotas(db);             // método que inserta mediante contentValues(clave-valor) seis valores en la tabla mascota
        }
        return db.obtenerTodasLasMascotas();  // retorna el método con la query SELECT * FROM mascota
    }

    public void insertarSeisMascotas (BaseDatos db){  // Insertamos estos datos Hardcodeados para tener registros (No hay entrada de estos datos por parte del usuario)
        //this.bandera = true;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rufo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog01);

        db.insertarMascota(contentValues); // inserta la mascota con los valores del contentValues

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Dogo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog02);

        db.insertarMascota(contentValues); // inserta la mascota con los valores del contentValues

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Koko");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog03);

        db.insertarMascota(contentValues); // inserta la mascota con los valores del contentValues

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Khan");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog04);

        db.insertarMascota(contentValues); // inserta la mascota con los valores del contentValues

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Gigi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog05);

        db.insertarMascota(contentValues); // inserta la mascota con los valores del contentValues

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Benny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog06);

        db.insertarMascota(contentValues); // inserta la mascota con los valores del contentValues

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context); // creamos nuevo objeto BaseDatos
        ContentValues contentValues = new ContentValues(); // creamos nuevo objeto ContentValues
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId() );// campo id_mascota, id del objeto mascota
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE); // campo numero_likes, 1
        db.insertarLikeMascota(contentValues); // ya tenemos rellenos los datos con un contentValues, ahora llamamos al método de BaseDatos

    }

    public int obtenerLikesMascota(Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }
}

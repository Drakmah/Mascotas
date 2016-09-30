package com.echolima.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.echolima.mascotas.Mascota;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Fernando on 17/09/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Aqui se crea la estructura de la BBDD
        // String queryCrearTablaMascota = CREATE TABLE MASCOTA(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, foto INTEGER);
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER" +
                                        ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE mascota_likes(id INTEGER PRIMARY KEY AUTOINCREMENT, id_mascota INTEGER, numero_likes INTEGER, FOREIGN KEY(id_mascota) REFERENCES mascota(id))";

        /*String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA    + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES   + " INTEGER, " +
                                        "FOREIGN KEY(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + ") " +
                                        "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +ConstantesBaseDatos.TABLE_MASCOTAS_ID  + ")" +

                                        ")";*/

        sqLiteDatabase.execSQL(queryCrearTablaMascota);
        sqLiteDatabase.execSQL((queryCrearTablaLikesMascota));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " +ConstantesBaseDatos.TABLE_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " +ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(sqLiteDatabase);

    }


    // ------------------------------------------------------------------------------------------
    public ArrayList<Mascota> obtenerfavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT nombre, foto, COUNT(m1.numero_likes)  AS total_likes FROM mascota m, mascota_likes m1 WHERE m.id = m1.id_mascota GROUP BY nombre ORDER BY total_likes DESC LIMIT 5";
        //String query = "SELECT nombre, foto, ml.numero_likes FROM mascota m, mascota_likes ml WHERE m.id = ml.id_mascota ORDER BY ml.numero_likes LIMIT 5";
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            //mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setRate(registros.getInt(2));


            mascotas.add(mascotaActual);
        }

        sqLiteDatabase.close();
        return mascotas;
    }
    //-------------------------------------------------------------------------------------------
    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS; // SELECT * FROM mascota
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); // abrimos conexion a la BBDD en forma de escritura
        Cursor registros = sqLiteDatabase.rawQuery(query, null); // El cursor "registros" apunta a los datos de la query

        while (registros.moveToNext()){  // Creamos un objeto Mascota con cada iteracion, hasta que el cursor no pueda moverse a "NEXT"
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0)); // Setea el valor del campo Id con lo que haya en el indice 0 ---> el Id
            mascotaActual.setNombre(registros.getString(1)); // Setea el valor del campo Nombre con lo que haya en el indice 1---> el Nombre
            mascotaActual.setFoto(registros.getInt(2)); // Setea el valor del campo foto con lo que haya en el indice 3---> La foto

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+") as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = sqLiteDatabase.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setRate(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRate(0); // si no hay registros en la query, entonces que lo ponga a 0
            }

            mascotas.add(mascotaActual); // LLenamos el Arraylist con el objeto mascotaActual construido en la iteracion, a falta de los likes

        }
        sqLiteDatabase.close(); // Cerramos la conexion a la base de datos
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();  // Abrimos una conexion a la BBDD
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues); // Se introducen los datos mediante clave-valor (contentValues) en la tabla "mascota"
        db.close(); // cerramos la conexion

    }

    public int recuentodatos (){ // Metodo que devuelve el numero de columnas en la tabla mascota
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS; // query SELECT * FROM mascota
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); // abrimos conexion a la BBDD en forma de escritura
        Cursor registros = sqLiteDatabase.rawQuery(query, null); // El cursor "registros" apunta a los datos de la query
        int num_registros = registros.getCount();
        sqLiteDatabase.close(); // cerramos la conexion
        return num_registros;
    }

    public void insertarLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase(); // Abrimos una conexion en modo estricura
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS, null, contentValues); // Vamos a introducir datos en la tabla "mascota_likes" mediante clave-valor
        db.close();// cerramos la conexion
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        //String query = "SELECT COUNT(numero_likes) FROM mascota_likes WHERE id_mascota = mascota.getId()";
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+")"+
                " FROM "+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " +ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();// abrimos una conexion a la Base de datos
        Cursor registros = db.rawQuery(query, null); // guardamos en un cursor el query

        if (registros.moveToNext()){ // utilizamos if porque la query solo va a devolver un solo registro

            likes = registros.getInt(0);// guardamos en la variable likes lo que haya en el registro 0 (solo hay una columna)
        }
        db.close();

        return likes;
    }
}

package com.echolima.mascotas.db;

/**
 * Created by Fernando on 17/09/2016.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    // ------------------- TABLA MASCOTA -----------------------------
    public static final String TABLE_MASCOTAS           = "mascota";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";

    // -------------------- TABLA MASCCOTA_LIKES ---------------------------------
    public static final String TABLE_LIKES_MASCOTAS             = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID          = "id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_MASCOTAS_NUMERO_LIKES = "numero_likes";
}

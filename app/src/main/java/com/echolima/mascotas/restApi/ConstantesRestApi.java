package com.echolima.mascotas.restApi;

/**
 * Created by Fernando on 30/09/2016.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION                   = "/v1/";
    public static final String ROOT_URL                  = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN              = "3977997813.cb06a95.048010f25d9b4db2ad44f6eb13205f2a";
    public static final String KEY_ACCESS_TOKEN          = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    // https://api.instagram.com/v1/
    // users/3981781866/media/recent/?access_token=3977997813.cb06a95.048010f25d9b4db2ad44f6eb13205f2a

    public static final String KEY_USERS                    = "users/";
    public static final String ID_USUARIO                         = "3981781866";
    public static final String KEY_GET_RECENT_MEDIA_USER2   = "/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER2 = KEY_USERS + ID_USUARIO + KEY_GET_RECENT_MEDIA_USER2 + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}

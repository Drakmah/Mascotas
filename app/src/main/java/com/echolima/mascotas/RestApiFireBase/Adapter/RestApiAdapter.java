package com.echolima.mascotas.RestApiFireBase.Adapter;

import com.echolima.mascotas.RestApiFireBase.ConstantesRestApiFireBase;
import com.echolima.mascotas.RestApiFireBase.EndpointsFireBase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando on 15/10/2016.
 */

public class RestApiAdapter {

    public EndpointsFireBase establecerConexionRestAPIFireBase(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApiFireBase.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(EndpointsFireBase.class);
    }
}

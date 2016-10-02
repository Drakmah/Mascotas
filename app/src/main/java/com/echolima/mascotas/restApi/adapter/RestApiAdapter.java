package com.echolima.mascotas.restApi.adapter;

import com.echolima.mascotas.restApi.ConstantesRestApi;
import com.echolima.mascotas.restApi.EndpointsApi;
import com.echolima.mascotas.restApi.deserializador.MascotaDeserializador;
import com.echolima.mascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando on 01/10/2016.
 */

public class RestApiAdapter {

        public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantesRestApi.ROOT_URL) // "//https://api.instagram.com/v1/"
                    .addConverterFactory(GsonConverterFactory.create(gson))  // aqui se describe como queremos recibir los datos
                    .build();
            return retrofit.create(EndpointsApi.class);

        }

    // todo lo que deserialice MascotaDeserializador lo asociará al objeto MascotaResponse
    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
}

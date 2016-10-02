package com.echolima.mascotas.restApi;

import com.echolima.mascotas.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fernando on 30/09/2016.
 */

public interface EndpointsApi {

    //@GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER2)
    Call<MascotaResponse> getRecentMedia(); // Definimos la respuesta del Endpoint: Un arreglo de mascotas
}

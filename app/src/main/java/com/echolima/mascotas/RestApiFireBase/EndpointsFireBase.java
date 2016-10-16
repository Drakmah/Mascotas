package com.echolima.mascotas.RestApiFireBase;

import com.echolima.mascotas.RestApiFireBase.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Fernando on 15/10/2016.
 */

public interface EndpointsFireBase {

    @FormUrlEncoded
    @POST(ConstantesRestApiFireBase.KEY_POST_ID_TOKEN)
     // No se puede añadir el Endpoint porque no registra correctamente el servicio Auth de FireBase
    //Call<UsuarioResponse> registrarTokenID(@Field("token") String token, @Field("user") String user);
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token);

    @GET(ConstantesRestApiFireBase.KEY_TOQUE_USUARIO)
    Call<UsuarioResponse> toqueanimal(@Path("id") String id, @Path("user") String user);
}

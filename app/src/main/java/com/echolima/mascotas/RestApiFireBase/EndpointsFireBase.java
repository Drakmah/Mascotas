package com.echolima.mascotas.RestApiFireBase;

import com.echolima.mascotas.RestApiFireBase.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Fernando on 15/10/2016.
 */

public interface EndpointsFireBase {

    @FormUrlEncoded
    @POST(ConstantesRestApiFireBase.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token);
}

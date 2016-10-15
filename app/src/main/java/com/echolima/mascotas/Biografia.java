package com.echolima.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.echolima.mascotas.RestApiFireBase.Adapter.RestApiAdapter;
import com.echolima.mascotas.RestApiFireBase.EndpointsFireBase;
import com.echolima.mascotas.RestApiFireBase.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biografia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biografia);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar2); // esta linea junto con la de abajo setea el Toolbar creado en actionBar2.xml
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Esta linea activa la flecha hacia atras para volver a MainActivity

        miToolbar.setNavigationIcon(R.drawable.ic_action_flecha_izda); // setea el icono de navegacion

    }

    public void enviarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);

    }
    public void enviarTokenRegistro(String token){
        Log.d("Token ", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsFireBase endpointsFireBase = restApiAdapter.establecerConexionRestAPIFireBase();
        Call<UsuarioResponse> usuarioResponseCall = endpointsFireBase.registrarTokenID(token);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponse.getToken());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }
}

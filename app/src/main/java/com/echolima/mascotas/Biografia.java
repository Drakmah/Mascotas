package com.echolima.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.echolima.mascotas.RestApiFireBase.Adapter.RestApiAdapter;
import com.echolima.mascotas.RestApiFireBase.EndpointsFireBase;
import com.echolima.mascotas.RestApiFireBase.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biografia extends AppCompatActivity {


    public String user = "Usuario01";
    private static final String USUARIO_EMISOR = "emisor";
    private static final String USUARIO_RECEPTOR = "receptor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biografia);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar2); // esta linea junto con la de abajo setea el Toolbar creado en actionBar2.xml
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Esta linea activa la flecha hacia atras para volver a MainActivity

        miToolbar.setNavigationIcon(R.drawable.ic_action_flecha_izda); // setea el icono de navegacion

        // Fallo al no iniciarse el servicio Auth de FireBase como servicio
        /*Bundle parametros = getIntent().getExtras();
        user = parametros.getString("user");*/


    }

    public void servicioFireBaseErrorAuth (View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token ", token);

    }


    public void enviarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);

    }
    public void enviarTokenRegistro(String token){
        //Log.d("Token ", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsFireBase endpointsFireBase = restApiAdapter.establecerConexionRestAPIFireBase();
        Call<UsuarioResponse> usuarioResponseCall = endpointsFireBase.registrarTokenID(token); // añadir aqui la variable usuario, desactivada por fallo de Auth FireBase

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
    public void toqueUsuario (View v){
        Log.d("TOQUE_USUARIO", "true");
        UsuarioResponse usuarioResponse = new UsuarioResponse("-KUCsGi-enc8-6E_gIlt", "123", "Usuario01");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsFireBase endpointsFireBase = restApiAdapter.establecerConexionRestAPIFireBase();
        Call<UsuarioResponse> usuarioResponseCall = endpointsFireBase.toqueanimal(usuarioResponse.getId(), usuarioResponse.getUser());

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body(); // respuesta de la base de datos
                Log.d("ID_FIREBASE2", usuarioResponse1.getId());
                Log.d("TOKEN_FIREBASE2", usuarioResponse1.getToken());
                Log.d("USER_FIREBASE2", usuarioResponse1.getUser());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }
}

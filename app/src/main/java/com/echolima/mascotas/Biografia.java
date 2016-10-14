package com.echolima.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;

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

    public void solicitarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);

    }
    public void enviarTokenRegistro(String token){
        Log.d("Token ", token);
    }
}

package com.echolima.mascotas;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.echolima.mascotas.restApi.ConstantesRestApi;

public class LoginCuenta extends AppCompatActivity {

    String nombreLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cuenta);


        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar2);// esta linea junto con la de abajo setea el Toolbar creado en actionBar2.xml
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Esta linea activa la flecha hacia atras para volver a MainActivity

        miToolbar.setNavigationIcon(R.drawable.ic_action_flecha_izda); // setea el icono de navegacion

        Button botonLogin = (Button) findViewById(R.id.btnBotonLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Codigo al presionar el boton

                EditText id = (EditText) findViewById(R.id.etLoginNombre);
                nombreLogin = id.getText().toString();
                Toast.makeText(LoginCuenta.this, "Has configurado la cuenta de " + nombreLogin, Toast.LENGTH_SHORT).show();

            }
        });

    }
}

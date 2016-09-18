package com.echolima.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class Comentarios extends AppCompatActivity {

    String nombreFormulario;
    String mailFormulario;
    String comentarioFormulario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar2);// esta linea junto con la de abajo setea el Toolbar creado en actionBar2.xml
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Esta linea activa la flecha hacia atras para volver a MainActivity

        miToolbar.setNavigationIcon(R.drawable.ic_action_flecha_izda); // setea el icono de navegacion


        Button botonFormulario = (Button) findViewById(R.id.btnBoton1);

        botonFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Código al presionar el boton

                EditText nombre = (EditText) findViewById(R.id.etNombreFormulario);
                nombreFormulario = nombre.getText().toString();

                EditText mail = (EditText) findViewById(R.id.etMailFormulario);
                mailFormulario = mail.getText().toString();

                EditText comentario = (EditText) findViewById(R.id.etmensajeFormulario);
                comentarioFormulario = comentario.getText().toString();

                String asunto = "Comentario de "+ nombreFormulario;

                Intent itSend = new Intent(Intent.ACTION_SEND);
                itSend.setType("plain/text");
                itSend.putExtra(Intent.EXTRA_EMAIL, new String[]{ mailFormulario});
                itSend.putExtra(Intent.EXTRA_SUBJECT, asunto);
                itSend.putExtra(Intent.EXTRA_TEXT, comentarioFormulario);

                startActivity(itSend);


            }
        });
    }
}

package com.echolima.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> favoritos;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar2); // esta linea junto con la de abajo setea el Toolbar creado en actionBar2.xml
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Esta linea activa la flecha hacia atras para volver a MainActivity

        miToolbar.setNavigationIcon(R.drawable.footprint); // setea el icono de navegacion






        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasfavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llm);

        inicializarListaMascotasfav();
        inicializarAdaptador();



    }

    public void inicializarListaMascotasfav() {
        favoritos = new ArrayList<Mascota>();

        favoritos.add(new Mascota(R.drawable.dog05, "Nina", 0)); // he cambiado los rates de string a int para el metodo suma de MascotaAdaptador y FavoritoAdaptador
        favoritos.add(new Mascota(R.drawable.dog01, "Bobby", 0));
        favoritos.add(new Mascota(R.drawable.dog03, "Yoyo", 0));
        favoritos.add(new Mascota(R.drawable.dog02, "Frey", 0));
        favoritos.add(new Mascota(R.drawable.dog04, "Arly", 0));

    }

    public void inicializarAdaptador (){
        FavoritoAdaptador adaptador = new FavoritoAdaptador(favoritos, this);
        listaMascotasFav.setAdapter(adaptador);

    }
}

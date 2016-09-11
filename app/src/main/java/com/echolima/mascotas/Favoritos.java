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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasfavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llm);

        inicializarListaMascotasfav();
        inicializarAdaptador();



    }

    public void inicializarListaMascotasfav() {
        favoritos = new ArrayList<Mascota>();

        favoritos.add(new Mascota(R.drawable.dog05, "Nina", "7"));
        favoritos.add(new Mascota(R.drawable.dog01, "Bobby", "8"));
        favoritos.add(new Mascota(R.drawable.dog03, "Yoyo", "14"));
        favoritos.add(new Mascota(R.drawable.dog02, "Frey", "10"));
        favoritos.add(new Mascota(R.drawable.dog04, "Arly", "9"));

    }

    public void inicializarAdaptador (){
        FavoritoAdaptador adaptador = new FavoritoAdaptador(favoritos, this);
        listaMascotasFav.setAdapter(adaptador);

    }
}

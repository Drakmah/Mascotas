package com.echolima.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.echolima.mascotas.presentador.FavoritosPresenter;
import com.echolima.mascotas.presentador.IFavoritosPresenter;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity implements IFavoritosView{

    ArrayList<Mascota> favoritos;
    private RecyclerView listaMascotasFav;
    private IFavoritosPresenter presenter;  // Interfaz Presentador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar2); // esta linea junto con la de abajo setea el Toolbar creado en actionBar2.xml
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Esta linea activa la flecha hacia atras para volver a MainActivity
        miToolbar.setNavigationIcon(R.drawable.ic_action_flecha_izda); // setea el icono de navegacion

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasfavoritas);

        presenter = new FavoritosPresenter(this, getBaseContext());  // Al construirse el objeto, llamará a la clase constructora y se ejecutará la cadena
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);

    }

    @Override
    public FavoritoAdaptador crearAdaptador(ArrayList<Mascota> favoritos) {

        FavoritoAdaptador adaptador = new FavoritoAdaptador(favoritos, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador) {

        listaMascotasFav.setAdapter(adaptador);

    }
}

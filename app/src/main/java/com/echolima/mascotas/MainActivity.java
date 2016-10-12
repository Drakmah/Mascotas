package com.echolima.mascotas;


import android.content.Intent;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        // toolbar.setLogo(R.drawable.footprint); --> Setea el Logo de la aplicacion (Desactivado porque Material Design no recomienda añadir logos)
        // toolbar.setTitleMarginStart(150);  --> setea el margen izquierdo en pixeles (Desactivado, su funcion era separar el texto del logo )

        setUpViewPager();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mFavoritos:
                Intent intent = new Intent(this, Favoritos.class);
                //startActivity(intent);
                break;
            case R.id.mContacto:
                //ejecutar código
                Intent linkComentario = new Intent(this, Comentarios.class);
                startActivity(linkComentario);
                break;
            case R.id.mAcercaDe:
                Intent linkAcercaDe = new Intent(this, Biografia.class);
                startActivity(linkAcercaDe);
                break;
            case R.id.mConfigurarCuenta:
                Intent linkLogin = new Intent(this, LoginCuenta.class);
                startActivity(linkLogin);
                break;

        }

        return super.onOptionsItemSelected(item);
    }



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentPrincipal());
        fragments.add(new FragmentPerfil());

        return fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_dog);

    }


}

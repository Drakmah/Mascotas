package com.echolima.mascotas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class FragmentPerfil extends Fragment {

    ArrayList<MascotaGrid> mascotasgrid;
    private RecyclerView listaMascotasgrid;


    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_fragment_perfil, container, false);



        listaMascotasgrid = (RecyclerView) v.findViewById(R.id.rvMascotasGrid);

        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaMascotasgrid.setLayoutManager(glm);

        inicializarListaMascotasGrid();

        inicializarAdaptadorGrid();

        return v;
    }

    public void inicializarAdaptadorGrid (){

        GridAdaptador adaptador = new GridAdaptador(mascotasgrid);
        listaMascotasgrid.setAdapter(adaptador);

    }

    public void inicializarListaMascotasGrid() {
        mascotasgrid = new ArrayList<MascotaGrid>();

        mascotasgrid.add(new MascotaGrid(R.drawable.dog_picture, "7"));
        mascotasgrid.add(new MascotaGrid(R.drawable.dog_picture, "4"));
        mascotasgrid.add(new MascotaGrid(R.drawable.dog_picture, "6"));
        mascotasgrid.add(new MascotaGrid(R.drawable.dog_picture, "2"));
        mascotasgrid.add(new MascotaGrid(R.drawable.dog_picture, "8"));
        mascotasgrid.add(new MascotaGrid(R.drawable.dog_picture, "5"));
    }

}
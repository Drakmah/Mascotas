package com.echolima.mascotas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class FragmentPrincipal extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

   /* public FragmentPrincipal() {
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_principal, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador (){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.dog01, "Bobby", "7"));
        mascotas.add(new Mascota(R.drawable.dog02, "Frey", "4"));
        mascotas.add(new Mascota(R.drawable.dog03, "Yoyo", "6"));
        mascotas.add(new Mascota(R.drawable.dog04, "Arly", "2"));
        mascotas.add(new Mascota(R.drawable.dog05, "Nina", "8"));
    }

}

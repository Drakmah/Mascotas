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
import android.widget.Toast;

import com.echolima.mascotas.presentador.FragmentPrincipalPresenter;
import com.echolima.mascotas.presentador.IFragmentPrincipalPresenter;

import java.util.ArrayList;



public class FragmentPrincipal extends Fragment implements IFragmentPrincipalView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IFragmentPrincipalPresenter presenter; // Interfaz Presenter

   /* public FragmentPrincipal() {
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_principal, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new FragmentPrincipalPresenter(this, getContext()); // Instanciamos con la clase Presenter
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {

        listaMascotas.setAdapter(adaptador);

    }
}

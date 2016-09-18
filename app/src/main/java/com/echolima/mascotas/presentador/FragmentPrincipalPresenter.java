package com.echolima.mascotas.presentador;

import android.content.Context;

import com.echolima.mascotas.IFragmentPrincipalView;
import com.echolima.mascotas.Mascota;
import com.echolima.mascotas.MascotaAdaptador;
import com.echolima.mascotas.db.CostructorMascotas;

import java.util.ArrayList;

/**
 * Created by Fernando on 16/09/2016.
 */
public class FragmentPrincipalPresenter  implements IFragmentPrincipalPresenter{

    private IFragmentPrincipalView iFragmentPrincipalView;
    private Context context;
    private CostructorMascotas costructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FragmentPrincipalPresenter(IFragmentPrincipalView iFragmentPrincipalView , Context context) {
        this.iFragmentPrincipalView = iFragmentPrincipalView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {

        costructorMascotas = new CostructorMascotas(context);
        mascotas = costructorMascotas.obtenerDatos();
        mostrarMascotasRV();



    }

    @Override
    public void mostrarMascotasRV() {
        iFragmentPrincipalView.inicializarAdaptadorRV(iFragmentPrincipalView.crearAdaptador(mascotas));
        iFragmentPrincipalView.generarLinearLayoutVertical();

    }
}

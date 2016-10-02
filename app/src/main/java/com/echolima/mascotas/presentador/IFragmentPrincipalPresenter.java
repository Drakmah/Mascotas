package com.echolima.mascotas.presentador;

/**
 * Created by Fernando on 16/09/2016.
 */
public interface IFragmentPrincipalPresenter {

    public void obtenerMascotasBaseDatos(); // Obtiene las mascotas de la BBDD

    void obtenerMediosRecientes(); // Obtiene las mascotas de Instagram

    public void mostrarMascotasRV();

}

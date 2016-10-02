package com.echolima.mascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.echolima.mascotas.IFragmentPrincipalView;
import com.echolima.mascotas.Mascota;
import com.echolima.mascotas.MascotaAdaptador;
import com.echolima.mascotas.db.CostructorMascotas;
import com.echolima.mascotas.restApi.EndpointsApi;
import com.echolima.mascotas.restApi.adapter.RestApiAdapter;
import com.echolima.mascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obtenerMascotasBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerMascotasBaseDatos() {

        costructorMascotas = new CostructorMascotas(context);
        mascotas = costructorMascotas.obtenerDatos();
        mostrarMascotasRV();



    }

    @Override
    public void obtenerMediosRecientes() {
        // mediante este metodo obtendremos los datos desde Instagram

        RestApiAdapter restApiAdapter = new RestApiAdapter();                                               // definimos un objeto adaptador
        Gson gsonmediarecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();                     // construimos la forma en que queremos deserializar los datos
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonmediarecent);     // establecemos la conexion y le pasamos la manera en que queremos recibir la respuesta
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();          // ejecutamos la llamada para pedir el RecentMedia

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {  // controlamos los eventos de la peticion - si falla o si responde correctamente
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body(); // aqui está la data
                mascotas = mascotaResponse.getMascotas(); // almacenamos en el arraylist mascotas la data
                mostrarMascotasRV(); // mostramos el recyclerview (metodo escrito abajo)

            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexion! Intenta de nuevo", Toast.LENGTH_LONG).show(); // mensaje para el usuario
                Log.e("FALLÓ LA CONEXION", t.toString()); // mensaje para nosotros, e impresión del error

            }
        });


    }

    @Override
    public void mostrarMascotasRV() {
        iFragmentPrincipalView.inicializarAdaptadorRV(iFragmentPrincipalView.crearAdaptador(mascotas));
        iFragmentPrincipalView.generarGridLayout();

    }
}

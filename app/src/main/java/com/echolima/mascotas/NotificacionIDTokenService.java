package com.echolima.mascotas;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Fernando on 12/10/2016.
 */

public class NotificacionIDTokenService extends FirebaseInstanceIdService{

    private static final String TAG = "FIREBASE_TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken(); // Se registra nuestro dispositivo, verifica el project number y devuelve el token
        enviarTokenRegistro(token); // enviamos el token a nuestro servidor ---> metodo descrito abajo

    }

    private void enviarTokenRegistro(String token){
        Log.d(TAG, token);
    }
}

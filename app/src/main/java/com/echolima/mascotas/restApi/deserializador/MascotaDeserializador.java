package com.echolima.mascotas.restApi.deserializador;

import com.echolima.mascotas.Mascota;
import com.echolima.mascotas.restApi.JsonKeys;
import com.echolima.mascotas.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Fernando on 01/10/2016.
 */

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class); // del json que estás trayendo, asemejalo con la clase MascotaResponse. Y lo asignamos a un objeto mascotaResponse
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY); // mascotaResponseData ahora tiene los datos de "data" devuelta por el JSON

        // seteamos el objeto mascotaResponse con el return de deserializarMascotaDeJson (al cual le pasamos los datos mediante mascotaResponseData)
        mascotaResponse.setMascotas(deserializarMascotaDeJson(mascotaResponseData));
        return mascotaResponse; // devolvemos el objeto mascotaResponse, que tiene ya todos los datos deserializados
    }

    private ArrayList<Mascota> deserializarMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject(); // mascotaResponseDataObject = primer objeto de "data"

            JsonObject userJson     = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER); // obtenemos el objeto Json cuya clave es "user"
            String id               = userJson.get(JsonKeys.USER_ID).getAsString(); // obtenemos el id que hay dentro del objeto userJson y lo convertimos a string
            String nombreCompleto   = userJson.get(JsonKeys.USER_FULLNAME).getAsString(); // obtenemos el fullname del objeto userJson y lo convertimos a string

            JsonObject imageJson            = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES); // Obtenemos objeto images
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);  // Obtenemos objeto Standard_resolution
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString(); // Obtenemos String url

            JsonObject likesJson    = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES); // Obtenemos el objeto likes
            int likes               = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt(); // Obtenemos el Int count

            // *************LLENAMOS EL OBJETO mascotaActual***********************
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombreCompleto(nombreCompleto);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setRate(likes);
            //*****LLENAMOS EL ARRAYLIST*****************
            mascotas.add(mascotaActual);
        }
        return mascotas; // devolvemos el Arraylist lleno
    }
}

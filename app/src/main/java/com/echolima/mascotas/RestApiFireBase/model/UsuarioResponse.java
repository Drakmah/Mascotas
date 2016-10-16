package com.echolima.mascotas.RestApiFireBase.model;

/**
 * Created by Fernando on 15/10/2016.
 */

public class UsuarioResponse {
    // modelo de los datos
    private String id;
    private String token;
    private String user;

    public UsuarioResponse(String id, String token, String user) {
        this.id = id;
        this.token = token;
        this.user = user;
    }

    public UsuarioResponse(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public UsuarioResponse() { //metodo constructor vacío
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

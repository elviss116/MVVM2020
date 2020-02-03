package com.example.mvvm2020.listRecycler_mvvm.model;

import com.google.gson.annotations.SerializedName;

public class UsuarioOb {

    @SerializedName("id_usuario")
    private String idpk;

    @SerializedName("id")
    private String id;

    @SerializedName("password")
    private String pass;

    public String getIdpk() {
        return idpk;
    }

    public void setIdpk(String idpk) {
        this.idpk = idpk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
package com.example.mvvm2020.save_mvvm;

import com.example.mvvm2020.listRecycler_mvvm.model.UsuarioOb;
import com.example.mvvm2020.listRecyclerFilter_mvvm.model.UsuarioOb2;
import com.example.mvvm2020.save_mvvm.object.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {

    @FormUrlEncoded
    @POST("retrofit_save_mvvm.php")
    Call<Usuario> saveUsuario(
            @Field("id") String id,
            @Field("password") String password
    );


    @GET("retrofit_listar.php")
    Call<List<UsuarioOb>> getUsu();


    @GET("retrofit_listar.php")
    Call<List<UsuarioOb2>> getUsu2();
}

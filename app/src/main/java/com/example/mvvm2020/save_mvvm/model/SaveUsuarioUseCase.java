package com.example.mvvm2020.save_mvvm.model;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm2020.save_mvvm.ApiClient;
import com.example.mvvm2020.save_mvvm.RetrofitModul;
import com.example.mvvm2020.save_mvvm.object.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SaveUsuarioUseCase {

    private MutableLiveData<String> data = new MutableLiveData<>();
    public String respuesta;


    public MutableLiveData<String> setData(String id, String password){

        ApiClient apiClient = RetrofitModul.getApiClient().create(ApiClient.class);
        Call<Usuario> usuarioCall = apiClient.saveUsuario(id,password);
        usuarioCall.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if (success){
                        data.setValue(response.body().getMessage());
                    }
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                data.setValue(t.getLocalizedMessage());
            }
        });
        return data;
    }
    /*
    public String grabar(String id, String pass)
    {
        ApiClient apiClient = RetrofitModul.getApiClient();
        Call<UsuarioOb2> usuarioCall = apiClient.saveUsuario(id,pass);
        usuarioCall.enqueue(new Callback<UsuarioOb2>() {
            @Override
            public void onResponse(Call<UsuarioOb2> call, Response<UsuarioOb2> response) {
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if (success){
                        respuesta = response.body().getMessage();
                    }
                }
            }
            @Override
            public void onFailure(Call<UsuarioOb2> call, Throwable t) {
                respuesta = t.getLocalizedMessage();
            }
        });
        return respuesta;
    } */

}

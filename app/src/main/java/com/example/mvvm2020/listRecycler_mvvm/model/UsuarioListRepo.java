package com.example.mvvm2020.listRecycler_mvvm.model;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm2020.save_mvvm.ApiClient;
import com.example.mvvm2020.save_mvvm.RetrofitModul;
import com.example.mvvm2020.save_mvvm2.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioListRepo {

    MutableLiveData<UsuarioListResponse> listMutableLiveData = new MutableLiveData<>();
    //MutableLiveData<String> postErr = new MutableLiveData<>();

    public MutableLiveData<UsuarioListResponse> getData(){

        ApiClient apiClient = RetrofitModul.getApiClient().create(ApiClient.class);
        Call<List<UsuarioOb>> usuarioObCall = apiClient.getUsu();
        usuarioObCall.enqueue(new Callback<List<UsuarioOb>>() {
            @Override
            public void onResponse(Call<List<UsuarioOb>> call, Response<List<UsuarioOb>> response) {
                if (response.isSuccessful() && response.body() != null){

                    listMutableLiveData.setValue(new UsuarioListResponse(response.body(),null));
                }else {
                    listMutableLiveData.setValue(new UsuarioListResponse(null,new Exception("Error en la carga")));
                }
            }
            @Override
            public void onFailure(Call<List<UsuarioOb>> call, Throwable t) {
                //postErr.setValue(t.getLocalizedMessage());
                listMutableLiveData.setValue(new UsuarioListResponse(null,new Exception(t)));
            }
        });
        return listMutableLiveData;

    }
}

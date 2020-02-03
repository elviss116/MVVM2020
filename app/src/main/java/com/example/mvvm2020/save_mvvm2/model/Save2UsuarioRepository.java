package com.example.mvvm2020.save_mvvm2.model;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm2020.save_mvvm.ApiClient;
import com.example.mvvm2020.save_mvvm.RetrofitModul;
import com.example.mvvm2020.save_mvvm.object.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Save2UsuarioRepository {

    private MutableLiveData<UserResponse> userResponse = new MutableLiveData<>();

    public MutableLiveData<UserResponse> setData(String id, String password){

        ApiClient apiClient = RetrofitModul.getApiClient().create(ApiClient.class);
        Call<Usuario> usuarioCall = apiClient.saveUsuario(id,password);
        usuarioCall.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful() && response.body() != null){
                    if (response.body().getSuccess()){
                        userResponse.setValue(new UserResponse(response.body().getMessage(),null));
                    }else {
                        userResponse.setValue(new UserResponse(null,new Exception("Ocurrio un error")));
                    }
                }else {
                    userResponse.setValue(new UserResponse(null,new Exception("Ocurrio un error")));

                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                userResponse.setValue(new UserResponse(null,new Exception(t)));
            }
        });
        return userResponse;
    }
}

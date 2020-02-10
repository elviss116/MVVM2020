package com.example.mvvm2020.save_mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm2020.save_mvvm.model.SaveUsuarioUseCase;
import com.example.mvvm2020.save_mvvm.object.Usuario;

public class sUsuarioViewModel extends ViewModel {
    private MutableLiveData<String> respuesta = new MutableLiveData<>();
    private SaveUsuarioUseCase saveUsuarioUseCase;

    /*
    public sUsuarioViewModel(UsuarioOb2 usuario){
        this.id = usuario.id;
        this.pwd = usuario.pass;
    } */

    public LiveData<String> getRespuestaLivedata(String id, String pwd){

        saveUsuarioUseCase = new SaveUsuarioUseCase();
        respuesta = saveUsuarioUseCase.setData(id,pwd);
        return respuesta;
    }


}

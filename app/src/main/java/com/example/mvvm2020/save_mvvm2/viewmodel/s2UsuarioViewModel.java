package com.example.mvvm2020.save_mvvm2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm2020.save_mvvm2.di.Injector;
import com.example.mvvm2020.save_mvvm2.model.Save2UsuarioRepository;
import com.example.mvvm2020.save_mvvm2.model.UserResponse;

public class s2UsuarioViewModel extends ViewModel {

    private Save2UsuarioRepository save2UsuarioRepository = Injector.getInstance().provideRepository();

    public LiveData<UserResponse> saveData(String id, String pwd){
        return save2UsuarioRepository.setData(id,pwd);
    }
}

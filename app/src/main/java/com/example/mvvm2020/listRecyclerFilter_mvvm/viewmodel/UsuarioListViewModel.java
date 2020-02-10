package com.example.mvvm2020.listRecyclerFilter_mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm2020.listRecyclerFilter_mvvm.di.Injector;
import com.example.mvvm2020.listRecyclerFilter_mvvm.model.UsuarioListRepo;
import com.example.mvvm2020.listRecyclerFilter_mvvm.model.UsuarioListResponse;


public class UsuarioListViewModel extends ViewModel {

    private UsuarioListRepo usuarioListRepo = Injector.getInstance().provideUsuarioListRepo();

    public LiveData<UsuarioListResponse> getData(){
        return usuarioListRepo.getData();
    }
}

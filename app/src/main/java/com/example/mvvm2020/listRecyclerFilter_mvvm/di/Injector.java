package com.example.mvvm2020.listRecyclerFilter_mvvm.di;


import com.example.mvvm2020.listRecyclerFilter_mvvm.model.UsuarioListRepo;

public class Injector {

    private static Injector injector;
    private UsuarioListRepo usuarioListRepo = new UsuarioListRepo();


    public static Injector getInstance(){

        if (injector==null)
            injector = new Injector();

        return injector;
    }

    public UsuarioListRepo provideUsuarioListRepo(){
        return usuarioListRepo;
    }
}

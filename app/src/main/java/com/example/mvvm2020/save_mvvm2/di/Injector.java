package com.example.mvvm2020.save_mvvm2.di;

import com.example.mvvm2020.save_mvvm2.model.Save2UsuarioRepository;

public class Injector {


    private static Injector injector;
    private Save2UsuarioRepository save2UsuarioRepository = new Save2UsuarioRepository();

    public static Injector getInstance(){
        if (injector == null)
            injector = new Injector();

        return injector;
    }

    public Save2UsuarioRepository provideRepository(){

        return save2UsuarioRepository;
    }
}

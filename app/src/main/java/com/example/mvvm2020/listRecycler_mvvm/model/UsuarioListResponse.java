package com.example.mvvm2020.listRecycler_mvvm.model;

import java.util.List;

public class UsuarioListResponse {

    private List<UsuarioOb> list;
    private Exception exception;

    public UsuarioListResponse(List<UsuarioOb> list, Exception exception) {
        this.list = list;
        this.exception = exception;
    }

    public List<UsuarioOb> getList() {
        return list;
    }

    public void setList(List<UsuarioOb> list) {
        this.list = list;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}

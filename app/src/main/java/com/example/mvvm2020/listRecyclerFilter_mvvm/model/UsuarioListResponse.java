package com.example.mvvm2020.listRecyclerFilter_mvvm.model;

import java.util.List;

public class UsuarioListResponse {

    private List<UsuarioOb2> list;
    private Exception exception;

    public UsuarioListResponse(List<UsuarioOb2> list, Exception exception) {
        this.list = list;
        this.exception = exception;
    }

    public List<UsuarioOb2> getList() {
        return list;
    }

    public void setList(List<UsuarioOb2> list) {
        this.list = list;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}

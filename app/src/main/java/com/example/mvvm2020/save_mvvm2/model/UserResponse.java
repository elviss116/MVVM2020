package com.example.mvvm2020.save_mvvm2.model;

public class UserResponse {

    private String data;
    private Exception error;

    public UserResponse(String data, Exception error){
        this.data = data;
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }
}

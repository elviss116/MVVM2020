package com.example.mvvm2020.save_mvvm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModul {

    //public static final String BASE_URL = "https://.000webhostapp.com/faucet/";
    public static final String BASE_URL = "http://192.168.1.150:85/faucet/";
    public static Retrofit retrofit;
    private static OkHttpClient.Builder httpClient;

    public static Retrofit getApiClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor());

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

    private static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}

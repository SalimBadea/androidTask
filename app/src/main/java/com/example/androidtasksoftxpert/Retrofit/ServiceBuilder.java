package com.example.androidtasksoftxpert.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    public Retrofit retrofit;

    public Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public OkHttpClient client = new OkHttpClient();

    public ServiceBuilder() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://demo1286023.mockable.io/api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public ServiceInterfaces.GetData getData(){
        return retrofit.create(ServiceInterfaces.GetData.class);
    }

}

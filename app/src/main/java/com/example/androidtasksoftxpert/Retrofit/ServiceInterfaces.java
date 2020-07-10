package com.example.androidtasksoftxpert.Retrofit;

import com.example.androidtasksoftxpert.Model.ModelDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceInterfaces {

    interface GetData{
        @GET("cars")
        Call<ModelDataResponse> getData(@Query("page") int page);
    }


}

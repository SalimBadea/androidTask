package com.example.androidtasksoftxpert.Ui;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.androidtasksoftxpert.Model.ModelDataResponse;
import com.example.androidtasksoftxpert.Retrofit.ServiceBuilder;
import com.example.androidtasksoftxpert.Retrofit.ServiceInterfaces;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DataViewModel extends ViewModel {

    MutableLiveData<List<ModelDataResponse.DataBean>> modelResponse = new MutableLiveData<>();

    public void getData(final int page){

        ServiceBuilder builder = new ServiceBuilder();
        ServiceInterfaces.GetData getData = builder.getData();
        Call<ModelDataResponse> call = getData.getData(page);
        call.enqueue(new Callback<ModelDataResponse>() {
            @Override
            public void onResponse(Call<ModelDataResponse> call, Response<ModelDataResponse> response) {
                Log.e(TAG, "onResponse: " + response);
                modelResponse.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<ModelDataResponse> call, Throwable t) {

            }
        });
    }
}

package com.example.androidtasksoftxpert.Ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtasksoftxpert.Adapter.AdapterData;
import com.example.androidtasksoftxpert.Model.ModelDataResponse;
import com.example.androidtasksoftxpert.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    DataViewModel dataViewModel;
    AdapterData adapterData;
    LinearLayoutManager linearLayoutManager;
    private int pageNumber = 1;
    private int itemsCount = 10;
    private boolean isLoading = true;
    private int pastVisibleItem, visibleItemsCount, totalItemsCount, previousTotal = 0;
    private int threshold = 5;

    @BindView(R.id.car_recyclerView)
    RecyclerView carRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        dataViewModel.getData(pageNumber);

        adapterData = new AdapterData(this);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        carRecyclerView.setLayoutManager(linearLayoutManager);
        carRecyclerView.setAdapter(adapterData);

        dataViewModel.modelResponse.observe(this, new Observer<List<ModelDataResponse.DataBean>>() {
            @Override
            public void onChanged(List<ModelDataResponse.DataBean> dataBeans) {
                adapterData.setCarsList(dataBeans);
            }
        });

        carRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);
                visibleItemsCount=linearLayoutManager.getChildCount();
                totalItemsCount=linearLayoutManager.getItemCount();
                pastVisibleItem=linearLayoutManager.findFirstVisibleItemPosition();

                if (dy>0){
                    if (isLoading){
                        if (totalItemsCount>previousTotal){
                            isLoading=false;
                            previousTotal=totalItemsCount;

                        }
                    }

                    if (!isLoading && (totalItemsCount-visibleItemsCount)<=(pastVisibleItem + threshold)){
                        pageNumber++;
                        isLoading=true;
                        dataViewModel.getData(pageNumber);
                    }
                }

            }
        });
    }

}

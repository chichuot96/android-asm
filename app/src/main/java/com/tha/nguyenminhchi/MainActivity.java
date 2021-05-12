package com.tha.nguyenminhchi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.tha.nguyenminhchi.adapter.MainAdapter;
import com.tha.nguyenminhchi.api.WeatherAPI;
import com.tha.nguyenminhchi.model.Weather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView tvTemperature, tvIconMain ;
    RecyclerView recyclerView;
    List<Weather> listWeather;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIconMain  = findViewById(R.id.tvIconMain );
        tvTemperature = findViewById(R.id.tvTemperature);

        getListData();

        listWeather = new ArrayList<>();
        adapter = new MainAdapter(this,listWeather);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);

        recyclerView = findViewById(R.id.rvForecast);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public  void getListData(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(WeatherAPI.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherAPI service = retrofit.create(WeatherAPI.class);
        service.getListData().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body() != null){
                    listWeather = response.body();
                    Weather weather = listWeather.get(0);
                    tvTemperature.setText(weather.getTemperature().getValue().toString() + "°");
                    tvIconMain.setText(weather.getIconPhrase());
                    adapter.reloadData(listWeather);

                }
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                tvIconMain.setText("lỗi");
            }
        });
    }

}
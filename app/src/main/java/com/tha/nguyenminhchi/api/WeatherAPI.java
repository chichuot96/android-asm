package com.tha.nguyenminhchi.api;

import com.tha.nguyenminhchi.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAPI {
    String URL="http://dataservice.accuweather.com";
    @GET("/forecasts/v1/hourly/12hour/353412?apikey=2WwaGhZF1Rj7IjE1NP5K2XS5ZTplRpC3&language=vi-vn&metric=true")
    Call<List<Weather>> getListData();
}

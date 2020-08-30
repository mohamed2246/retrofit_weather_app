package com.example.retrofit_weather_app.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_interface {
    @GET("weather?appid=a6f41d947e0542a26580bcd5c3fb90ef&units=metric")
    Call<Examble> get_weather_data(@Query("q") String name);
}

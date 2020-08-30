package com.example.retrofit_weather_app.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_client {
    private static Retrofit retrofit = null;
   public static  Retrofit getClient(){
        if (retrofit==null){
          return   retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        else
            return retrofit;

    };
}

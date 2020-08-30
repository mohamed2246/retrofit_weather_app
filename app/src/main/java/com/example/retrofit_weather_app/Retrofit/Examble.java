package com.example.retrofit_weather_app.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Examble {
    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

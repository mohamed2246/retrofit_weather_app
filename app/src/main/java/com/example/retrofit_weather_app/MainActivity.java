package com.example.retrofit_weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_weather_app.Retrofit.Api_client;
import com.example.retrofit_weather_app.Retrofit.Api_interface;
import com.example.retrofit_weather_app.Retrofit.Examble;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ImageView search;
    TextView temp_text , dec_text ,hum_text ;
    EditText city_edite_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search_btn);
        temp_text = findViewById(R.id.temp_text);
        dec_text = findViewById(R.id.desc_text);
        hum_text = findViewById(R.id.hum_text);
        city_edite_text = findViewById(R.id.seach_edite);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getweather(city_edite_text.getText().toString());
            }
        });
    }

    private void getweather(String name) {
        Api_interface api_interface = Api_client.getClient().create(Api_interface.class);
        Call<Examble> exambleCall = api_interface.get_weather_data(name);
        exambleCall.enqueue(new Callback<Examble>() {
            @Override
            public void onResponse(Call<Examble> call, Response<Examble> response) {
                temp_text.setText("Temp = "+response.body().getMain().getTemp().toString());
                dec_text.setText("Feels Like = "+response.body().getMain().getFeels_like().toString());
                hum_text.setText("Humidity = "+response.body().getMain().getHumidity().toString());
            }

            @Override
            public void onFailure(Call<Examble> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

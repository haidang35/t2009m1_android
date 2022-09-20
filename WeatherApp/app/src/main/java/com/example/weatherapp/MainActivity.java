package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.weatherapp.entity.WeatherForecast;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText edLong, edLat;
    private Button btnCheck;
    private ProgressBar progressData;
    private TextView tvDataSummary,tvDataTemp,tvDataHumidity,tvDataPressure,tvDataWindSpeed,tvDataCloudCover,tvDataUVIndex,tvDataVisibility,tvDataOzone;
    private LinearLayout weatherData;
    private static final String API_KEY = "a14fa83095msh4e61c2f7cc01530p112814jsnaa0c0896cb17";
    private static final String API_HOST = "dark-sky.p.rapidapi.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        edLat = findViewById(R.id.edLat);
        edLong = findViewById(R.id.edLong);
        btnCheck = findViewById(R.id.btnCheck);
        progressData = findViewById(R.id.progressData);
        tvDataSummary = findViewById(R.id.tvDataSummary);
        tvDataTemp = findViewById(R.id.tvDataTemp);
        tvDataHumidity = findViewById(R.id.tvDataHumidity);
        tvDataPressure = findViewById(R.id.tvDataPressure);
        tvDataWindSpeed = findViewById(R.id.tvDataWindSpeed);
        tvDataCloudCover = findViewById(R.id.tvDataCloudCover);
        tvDataUVIndex = findViewById(R.id.tvDataUVIndex);
        tvDataVisibility = findViewById(R.id.tvDataVisibility);
        tvDataOzone = findViewById(R.id.tvDataOzone);
        weatherData = findViewById(R.id.weatherData);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressData.setVisibility(View.VISIBLE);
                String latitude = edLat.getText().toString();
                String longitude = edLong.getText().toString();
                getWeatherData(longitude, latitude);
            }
        });
    }

    public void getWeatherData(String latitude, String longitude) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherRestAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherRestAPI weatherRestAPI = retrofit.create(WeatherRestAPI.class);
        weatherRestAPI.getData(longitude, latitude, "vi", API_KEY, API_HOST).enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                Log.i("Response body", response.toString());
                if(response.code() == 200) {
                    WeatherForecast weatherForecast = response.body();
                    if(weatherForecast != null) {
                        weatherData.setVisibility(View.VISIBLE);
                        tvDataSummary.setText(weatherForecast.getCurrently().getSummary());
                        tvDataCloudCover.setText(String.valueOf(weatherForecast.getCurrently().getCloudCover()));
                        tvDataHumidity.setText(String.valueOf(weatherForecast.getCurrently().getHumidity()));
                        tvDataOzone.setText(String.valueOf(weatherForecast.getCurrently().getOzone()));
                        tvDataPressure.setText(String.valueOf(weatherForecast.getCurrently().getPressure()));
                        tvDataWindSpeed.setText(String.valueOf(weatherForecast.getCurrently().getWindSpeed()));
                        tvDataTemp.setText(String.valueOf(weatherForecast.getCurrently().getTemperature()));
                        tvDataUVIndex.setText(String.valueOf(weatherForecast.getCurrently().getUvIndex()));
                        tvDataVisibility.setText(String.valueOf(weatherForecast.getCurrently().getVisibility()));
                        LocalDateTime time = formatDate(weatherForecast.getCurrently().getTime());
                        Log.i("TImee", time.toString());
                    }
                    progressData.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                Log.e("data 888888", t.getMessage());
            }
        });
    }

    public LocalDateTime formatDate(String timestamp) {
        //unix time
        Long unixTime = Long.parseLong(timestamp);
        Instant instant = Instant.ofEpochMilli(unixTime);
        // system default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //custom time zone
        ZoneId customZoneId = ZoneId.of("America/New_York");

        LocalDateTime defaultLocalDateTime = LocalDateTime.ofInstant(instant, defaultZoneId);
        LocalDateTime customLocalDateTime = LocalDateTime.ofInstant(instant, customZoneId);
        return defaultLocalDateTime;
    }
}
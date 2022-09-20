package com.example.weatherapp;

import com.example.weatherapp.entity.WeatherForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface WeatherRestAPI {
    String BASE_URL = "https://dark-sky.p.rapidapi.com/";

    @GET("{latitude},{longitude}")
    Call<WeatherForecast> getData(
            @Path("latitude") String latitude,
            @Path("longitude") String longitude,
            @Query("lang") String lang,
            @Header("X-RapidAPI-Key") String key,
            @Header("X-RapidAPI-Host") String host
    );
}

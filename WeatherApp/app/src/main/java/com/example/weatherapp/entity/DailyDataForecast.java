package com.example.weatherapp.entity;

public class DailyDataForecast extends CurrentlyForecast{
    private String temperatureMin;
    private String temperatureMinTime;
    private String temperatureMax;
    private String temperatureMaxTime;
    private String apparentTemperatureMin;
    private String apparentTemperatureMinTime;
    private String apparentTemperatureMax;
    private String apparentTemperatureMaxTime;

    public DailyDataForecast() {
    }

    public DailyDataForecast(String temperatureMin, String temperatureMinTime, String temperatureMax, String temperatureMaxTime, String apparentTemperatureMin, String apparentTemperatureMinTime, String apparentTemperatureMax, String apparentTemperatureMaxTime) {
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public DailyDataForecast(String time, String summary, String icon, float precipIntensity, float precipProbability, String precipType, float temperature, float apparentTemperature, float dewPoint, float humidity, float pressure, float windSpeed, float windGust, float windBearing, float cloudCover, float uvIndex, float visibility, float ozone, String temperatureMin, String temperatureMinTime, String temperatureMax, String temperatureMaxTime, String apparentTemperatureMin, String apparentTemperatureMinTime, String apparentTemperatureMax, String apparentTemperatureMaxTime) {
        super(time, summary, icon, precipIntensity, precipProbability, precipType, temperature, apparentTemperature, dewPoint, humidity, pressure, windSpeed, windGust, windBearing, cloudCover, uvIndex, visibility, ozone);
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(String temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(String temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public String getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(String apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public String getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(String apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public String getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(String apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public String getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(String apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }
}

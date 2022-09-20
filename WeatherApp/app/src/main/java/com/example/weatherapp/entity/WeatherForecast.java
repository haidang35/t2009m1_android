package com.example.weatherapp.entity;

public class WeatherForecast {
    private String latitude;
    private String longitude;
    private CurrentlyForecast currently;
    private HourlyForecast hourly;
    private DailyForecast daily;

    public WeatherForecast() {
    }

    public WeatherForecast(String latitude, String longitude, CurrentlyForecast currently, HourlyForecast hourly, DailyForecast daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.currently = currently;
        this.hourly = hourly;
        this.daily = daily;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public CurrentlyForecast getCurrently() {
        return currently;
    }

    public void setCurrently(CurrentlyForecast currently) {
        this.currently = currently;
    }

    public HourlyForecast getHourly() {
        return hourly;
    }

    public void setHourly(HourlyForecast hourly) {
        this.hourly = hourly;
    }

    public DailyForecast getDaily() {
        return daily;
    }

    public void setDaily(DailyForecast daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", currently=" + currently +
                ", hourly=" + hourly +
                ", daily=" + daily +
                '}';
    }
}

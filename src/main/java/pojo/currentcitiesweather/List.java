package pojo.currentcitiesweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pojo.currentweather.Rain;
import pojo.currentweather.Weather;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {

    private String id;
    private String name;
    private Coord coord;
    private Main main;
    private String dt;
    private Wind wind;
    private Sys sys;
//    private pojo.currentcitiesweather.Rain rain;
    private String snow;
    private Clouds clouds;
    private Weather[] weather;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

//    public pojo.currentcitiesweather.Rain getRain() {
//        return rain;
//    }
//
//    public void setRain(pojo.currentcitiesweather.Rain rain) {
//        this.rain = rain;
//    }

    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}

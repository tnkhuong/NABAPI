package pojo.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

    public CurrentWeather(){}

    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;

    public String getBase() { return base; }

    public void setBase(String base) { this.base = base; }

    public int getVisibility() { return visibility; }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Coord getCoord() { return coord; }

    public void setCoord(Coord coord) { this.coord = coord; }

    public Weather[] getWeather() { return weather; }

    public void setWeather(Weather[] weather) { this.weather = weather; }

    public Main getMain() { return main; }

    public void setMain(Main main) { this.main = main; }

    public Wind getWind() { return wind; }

    public void setWind(Wind wind) { this.wind = wind; }

    public Clouds getClouds() { return clouds; }

    public void setClouds(Clouds clouds) { this.clouds = clouds; }

    public Sys getSys() { return sys; }

    public void setSys(Sys sys) { this.sys = sys; }

    public Rain getRain() { return rain; }

    public void setRain(Rain rain) { this.rain = rain; }
}

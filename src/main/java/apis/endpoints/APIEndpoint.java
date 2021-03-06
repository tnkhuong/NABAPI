package apis.endpoints;

public enum APIEndpoint {

    CurrentCityWeather("/data/2.5/weather"),
    CurrentCitiesWeatherInCircle("/data/2.5/find");

    private String resource;

    APIEndpoint(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}

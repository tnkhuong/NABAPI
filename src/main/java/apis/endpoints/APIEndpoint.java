package apis.endpoints;

public enum APIEndpoint {

    CurrentWeatherAPI("/data/2.5/weather");

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

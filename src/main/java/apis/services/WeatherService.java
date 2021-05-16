package apis.services;

import apis.APIInit;
import apis.endpoints.APIEndpoint;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class WeatherService extends APIInit {

    String currentCityWeather = "CurrentCityWeather";
    String currentCitiesWeatherInCircle = "CurrentCitiesWeatherInCircle";
    APIEndpoint resourceAPI;

    public static RequestSpecification Request;

    public WeatherService() throws IOException {
        Request = RestAssured.given().spec(requestSpecification());
    }

    public Response getWeatherResponse(String cityName)
    {
        resourceAPI = APIEndpoint.valueOf("CurrentCityWeather");
        Request.queryParam("q",cityName);

        return Request.get(resourceAPI.getResource());
    }

    public Response getWeatherResponse(String cityName, String stateCode)
    {
        resourceAPI = APIEndpoint.valueOf("CurrentCityWeather");
        String qParam = cityName + "," + stateCode;

        Request.queryParam("q",qParam);

        return Request.get(resourceAPI.getResource());
    }

    public Response getWeatherResponse(String cityName, String stateCode, String countryCode)
    {
        resourceAPI = APIEndpoint.valueOf("CurrentCityWeather");

        String qParam = cityName + "," + stateCode + "," + countryCode;

        Request.queryParam("q",qParam);

        return Request.get(resourceAPI.getResource());
    }

    public Response getWeatherInCircleResponse(float latNumber, float lonNumber)
    {
        resourceAPI = APIEndpoint.valueOf("CurrentCitiesWeatherInCircle");

        Request.queryParam("lat",latNumber)
                .queryParam("lon",lonNumber);

        return Request.get(resourceAPI.getResource());
    }

    public Response getWeatherInCircleResponse(float latNumber, float lonNumber, int numberCity)
    {
        resourceAPI = APIEndpoint.valueOf("CurrentCitiesWeatherInCircle");

        Request.queryParam("lat",latNumber)
                .queryParam("lon",lonNumber)
                .queryParam("cnt",numberCity);

        return Request.get(resourceAPI.getResource());
    }
}

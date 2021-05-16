package stepdefinations;

import apis.APIInit;
import apis.endpoints.JsonFolder;
import apis.services.WeatherService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.currentcitiesweather.CurrentCitiesWeather;

import java.io.IOException;
import java.util.Arrays;

public class getSearchCitiesWeatherInCircle extends APIInit {

    //Response response;
    JsonFolder folderPath;

    @Given("User call search cities weather in circle with lat {string} and lon {string} without number of city")
    public void user_call_search_cities_weather_in_circle_with_lat_and_lon_without_number_of_city(String lat, String lon) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherInCircleResponse(Float.parseFloat(lat),Float.parseFloat(lon));
    }

    @Given("User call search cities weather in circle with lat {string} and lon {string} with number of city {string}")
    public void user_call_search_cities_weather_in_circle_with_lat_and_lon_with_number_of_city(String lat, String lon, String cont) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherInCircleResponse(Float.parseFloat(lat),Float.parseFloat(lon), Integer.parseInt(cont));
    }

    @Then("Body should return the info with {string} cities nearly that position")
    public void body_should_return_the_info_with_cities_nearly_that_position(String citiesNumber) {
        CurrentCitiesWeather ccw = response.getBody().as(CurrentCitiesWeather.class);
        Assert.assertEquals(Integer.parseInt(citiesNumber),Arrays.stream(ccw.getList()).count());
    }
}

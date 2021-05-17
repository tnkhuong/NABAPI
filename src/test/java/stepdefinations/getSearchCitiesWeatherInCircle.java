package stepdefinations;

import apis.APIInit;
import apis.endpoints.JsonFolder;
import apis.services.WeatherService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.currentcitiesweather.CurrentCitiesWeather;

import java.io.IOException;
import java.util.Arrays;

public class getSearchCitiesWeatherInCircle extends APIInit {

    @When("User calls Search Cities Weather in Circle API with lat {string} and lon {string} without number of city")
    public void user_calls_Search_Cities_Weather_in_Circle_API_with_lat_and_lon_without_number_of_city(String lat, String lon) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherInCircleResponse(Float.parseFloat(lat),Float.parseFloat(lon));
    }

    @When("User calls Search Cities weather in circle API with lat {string}, lon {string} and number of city {string}")
    public void user_calls_Search_Cities_weather_in_circle_API_with_lat_lon_and_number_of_city(String lat, String lon, String cont) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherInCircleResponse(Float.parseFloat(lat),Float.parseFloat(lon), Integer.parseInt(cont));
    }

    @Then("The response payload should return the weather info of {string} city\\(s) within the defined position")
    public void the_response_payload_should_return_the_weather_info_of_city_s_within_the_defined_position(String citiesNumber) {
        CurrentCitiesWeather ccw = response.getBody().as(CurrentCitiesWeather.class);
        Assert.assertEquals(Integer.parseInt(citiesNumber),Arrays.stream(ccw.getList()).count());
    }

}

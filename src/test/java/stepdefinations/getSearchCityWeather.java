package stepdefinations;

import apis.APIInit;
import apis.endpoints.JsonFolder;
import apis.services.WeatherService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.currentweather.CurrentWeather;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class getSearchCityWeather extends APIInit {

    @When("User calls search cities weather API with {string}")
    public void user_calls_search_cities_weather_API_with(String cityName) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherResponse(cityName);
    }

    @When("User calls search cities weather API with {string} of {string}")
    public void user_calls_search_cities_weather_API_with_of(String cityName, String countryName) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherResponse(cityName,countryName);
    }

    @Then("The response payload should return the weather info of {string} of {string}")
    public void the_response_payload_should_return_the_weather_info_of_of(String cityName, String countryName) {
        CurrentWeather cw = response.getBody().as(CurrentWeather.class);
        assertThat(cw.getName(), equalTo(cityName));
        assertThat(cw.getSys().getCountry(),equalTo(countryName));
    }

    @Then("The response payload should return the weather info of {string}")
    public void the_response_payload_should_return_the_weather_info_of(String city) {
        CurrentWeather cw = response.getBody().as(CurrentWeather.class);
        assertThat(cw.getName(), equalTo(city));
    }

}

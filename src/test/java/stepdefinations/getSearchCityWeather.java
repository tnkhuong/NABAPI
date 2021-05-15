package stepdefinations;

import apis.APIInit;
import apis.endpoints.JsonFolder;
import apis.services.WeatherService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.currentweather.CurrentWeather;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class getSearchCityWeather extends APIInit {

    //Response response;
    JsonFolder folderPath;

    @Given("User call searchWeatherAPI with http request for {string}")
    public void user_call_searchWeatherAPI_with_http_request_for(String cityName) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherResponse(cityName);
    }

    @Given("User call searchWeatherAPI with http request for {string} of {string}")
    public void user_call_searchWeatherAPI_with_http_request_for_of(String cityName, String countryName) throws IOException {
        WeatherService ws = new WeatherService();
        response = ws.getWeatherResponse(cityName,countryName);
    }

    @Then("Body should return the info {string} of {string}")
    public void body_should_return_the_info_of(String cityName, String countryName) {
        CurrentWeather cw = response.getBody().as(CurrentWeather.class);
        assertThat(cw.getName(), equalTo(cityName));
        assertThat(cw.getSys().getCountry(),equalTo(countryName));
    }

    @Then("Should return status {string}")
    public void should_return_status(String statusNumber) {
            Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusNumber));
    }

    @Then("Should return Content-Type {string}")
    public void should_return_Content_Type(String contentType) {
        Assert.assertEquals(response.contentType(), contentType);
    }

    @Then("Should return error message {string}")
    public void should_return_error_message(String string) {
        JsonPath js = new JsonPath(response.asString());
        Assert.assertEquals(js.get("message"),string);
    }

    @Then("Body should return the info {string}")
    public void body_should_return_the_info(String city) {
        CurrentWeather cw = response.getBody().as(CurrentWeather.class);
        assertThat(cw.getName(), equalTo(city));
    }

    @Then("Validate schema body return with json file {string} for {string}")
    public void validate_schema_body_return_with_json_file_for(String filename, String folder) {
        folderPath = JsonFolder.valueOf(folder);
        response.then().assertThat().body(matchesJsonSchemaInClasspath(folderPath.getResource() + "\\" + filename));
    }
}

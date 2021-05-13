package stepDefinations;

import apis.APIInit;
import apis.PostAPIsMethods;
import apis.services.WeatherService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.IOException;

public class StepDefination extends APIInit {

    Response response;

    @Given("Navigate the site")
    public void navigate_the_site() {

    }

    @When("User call searchWeatherAPI with http request for {string}")
    public void user_call_searchWeatherAPI_with_http_request_for(String city) throws IOException {

        WeatherService ws = new WeatherService();
        response = ws.getWeatherResponse(city);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Then("Body should return the info {string}")
    public void body_should_return_the_info(String city) {
        JsonPath js = new JsonPath(response.asString());
        Assert.assertEquals(js.get("name").toString(),city);
    }
}

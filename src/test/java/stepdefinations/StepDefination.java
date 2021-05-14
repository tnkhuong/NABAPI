package stepdefinations;

import apis.APIInit;
import apis.endpoints.JsonEndpoint;
import apis.services.WeatherService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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

    @Then("Validate schema body return with json file {string}")
    public void validate_schema_body_return_with_json_file(String filename) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(JsonEndpoint.CONTRACTS_DIRECTORY + "\\" + filename));
    }
}

package stepdefinations;

import apis.APIInit;
import apis.endpoints.JsonFolder;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class getGeneralSteps extends APIInit {

    @Then("It should return status {string}")
    public void it_should_return_status(String statusNumber) {
        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusNumber));
    }

    @Then("It should return Content-Type {string}")
    public void it_should_return_Content_Type(String contentType) {
        Assert.assertEquals(response.contentType(), contentType);
    }

    @Then("The response payload should return message {string}")
    public void the_response_payload_should_return_message(String errorMessage) {
        JsonPath js = new JsonPath(response.asString());
        Assert.assertEquals(js.get("message"),errorMessage);
    }

    @Then("It should response time less then {string} milliseconds")
    public void it_should_response_time_less_then_milliseconds(String milliSeconds) {
        if (response.getTime() <= Long.parseLong(milliSeconds)) {
            Assert.assertTrue(response.getTime() <= Long.parseLong(milliSeconds));
        }
        else
        {
            Assert.assertEquals(Long.parseLong(milliSeconds), response.getTime());
        }
    }

    @Then("The response body schema must match with json file {string} for checking the {string}")
    public void the_response_body_schema_must_match_with_json_file_for_checking_the(String filename, String folder) {
        JsonFolder folderPath = JsonFolder.valueOf(folder);
        response.then().assertThat().body(matchesJsonSchemaInClasspath(folderPath.getResource() + filename));
    }
}

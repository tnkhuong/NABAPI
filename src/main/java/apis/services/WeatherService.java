package apis.services;

import apis.APIInit;
import apis.APIResources;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class WeatherService extends APIInit {

    APIResources resourceAPI;

    public WeatherService(){

    }

    public Response getWeatherResponse(String city) throws IOException
    {
        resourceAPI=APIResources.valueOf("CurrentWeatherAPI");

        return given().spec(requestSpecification())
                .queryParam("q",city)
                .queryParam("appid","4ca6724091f531a02d20ec5c742d6db6")
                .when()
                .get(resourceAPI.getResource()).then().extract().response();
    }
}
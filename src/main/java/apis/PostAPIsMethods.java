package apis;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import apis.APIInit;
import io.restassured.response.Response;


public class PostAPIsMethods{

	APIInit apiinit = new APIInit();
	public GetPostResponsePayLoad getGetPostResponse(String id) throws IOException
	{
		GetPostResponsePayLoad gp=(given().spec(apiinit.requestSpecification()).urlEncodingEnabled(false).pathParam("id",URLDecoder.decode(id)).log().all().when().get("/typicode/demo/posts/{id}").as(GetPostResponsePayLoad.class));	
		return gp;
	}
	public List<GetPostResponsePayLoad> getGetPostResponse() throws IOException
	{	
		return Arrays.asList(given().spec(apiinit.requestSpecification())
	            .when()
	            .get("/typicode/demo/posts")
	            .then()
	            .extract()
	            .response()
	            .body()
	            .as(GetPostResponsePayLoad[].class));
	}
	public int getGetResponseStatus(String id) throws IOException
	{	
		return given().spec(apiinit.requestSpecification()).pathParam("id",id).when().get("/typicode/demo/posts/{id}").getStatusCode();
	}
	public Response getGetResponseStatus() throws IOException
	{	
		return given().spec(apiinit.requestSpecification())
	            .when()
	            .get("data/2.5/weather?q=London&appid=4ca6724091f531a02d20ec5c742d6db6").then().extract().response();
	}
	public String getGetResponseStatusMessage(String id) throws IOException
	{	
		return given().spec(apiinit.requestSpecification()).pathParam("id",id).when().get("/typicode/demo/posts/{id}").getStatusLine();
	}
	public String getGetResponseStatusMessage() throws IOException
	{	
		return given().spec(apiinit.requestSpecification()).when().get("/typicode/demo/posts").getStatusLine();
	}
}

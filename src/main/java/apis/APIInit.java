package apis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIInit {
	public static RequestSpecification req;
	public static PrintStream log;
	public static Response response;

	public RequestSpecification requestSpecification() throws IOException
	{		
		if(req==null)
		{
			log =new PrintStream(new FileOutputStream("logging.txt"));
			 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("appid",getGlobalValue("apiId"))
					 .addFilter(RequestLoggingFilter.logRequestTo(log))
					 .addFilter(ResponseLoggingFilter.logResponseTo(log))
					 .setContentType(ContentType.JSON).build();
			 return req;
		}
		return req;
	}

	public static String getGlobalValue(String key) throws IOException
	{
		String os = System.getProperty("os.name").toLowerCase();
		String propertiespath = ".\\src\\main\\java\\apis\\apiglobal.properties";
		if (os.contains("mac"))
   		{
			propertiespath = "src/main/java/apis/apiglobal.properties";
        }		
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream(propertiespath);
		prop.load(fis);
		return prop.getProperty(key);		
	}
}

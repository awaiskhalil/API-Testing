import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GET_Method {

	@Test
	void test_01() {
      Response response = get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/9");
   
      System.out.println(response.asString());
      //System.out.println(response.getBody().asString());
      System.out.println(response.getStatusCode());
      System.out.println(response.getStatusLine());
      System.out.println(response.getHeader("content-type"));
      System.out.println(response.getTime());

      int StatusCode = response.getStatusCode();
      Assert.assertEquals(StatusCode, 200);
	}
      
      @Test
      void test_02() {
    	  //Verify if Test Status code is matched or not
    	  given().
    	  get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/9").
    	  then().
    	  statusCode(201);
    	  	
      }
      @Test
      void test_03() {
    	  //Verify the case if -ve id is set or space is given then 404 not found should expect
    	  given().
    	  get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/-9").
    	  then().
    	  statusCode(200).
    	  log().all();
    	  	
      }
      @Test
      void test_04() {
    	  //Verify the case if invalid brand id is set then 404 not found should expect
    	  given().
    	  get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/100").
    	  then().
    	  statusCode(404).
    	  log().all();    	  	
      }
      @Test
      void test_05() {
    	  //Verify the case if special char is set then 400 Client Bad Request should expect
    	  given().
    	  get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/'@#$%^&*'").
    	  then().
    	  statusCode(400).
    	  log().all();
    	  	
      }
      @Test
      void test_06() {
    	  //Verify the case if float point value is set then 404 not found should expect
    	  given().
    	  get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/0.9").
    	  then().statusCode(404).
    	  log().all();	
      }
      
}

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethod {

@Test
void test_01() {
      Response response = RestAssured.get("https://m2-beta-grubtech.dcafood.com/index.php/rest/eathosmultibrand_en/V1/leanscale/brand/9");
   
      System.out.println(response.asString());
      System.out.println(response.getBody().asString());
      System.out.println(response.getStatusCode());
      System.out.println(response.getStatusLine());
      System.out.println(response.getHeader("content-type"));
      System.out.println(response.getTime());

      int StatusCode = response.getStatusCode();
      Assert.assertEquals(StatusCode, 200);
	
	}
}

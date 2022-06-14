package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AlticciResourceTest {
    
    @Test
    public void testAlticciEndpoint() {
        given()
          .when().get("/alticci/0")
          .then()
             .statusCode(200)
             .body(is("0"));
    }
}

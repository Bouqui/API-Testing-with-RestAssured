package tests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FavQuote extends BaseTest {

    int quoteId = 4607;
    int invalidQuoteId = 1;

    @BeforeMethod(alwaysRun = true)
    public  void setPath() {
        RestAssured.basePath = "/api/quotes";
    }


    @Test
    public void markQuoteAsFavWithNoSession() {
        int error =
        given()
                .headers(getHeaderWithToken())
                .when().put(quoteId + "/fav")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().path("error_code");

        Assert.assertTrue(error==20, "incorrect error code is displayed");

    }

    @Test
    public void markQuoteAsFavWithValidQuoteId() {

        //Create a session before running this
                given()
                        .headers(getHeaderWithToken())
                        .when().put(quoteId + "/fav")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .log().all();

    }
    @Test
    public void markQuoteAsFavWithInvalidQuoteId() {

        //Create a session before running this
        String error =
        given()
                .headers(getHeaderWithToken())
                .when().put(invalidQuoteId + "/fav")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().all()
                .extract().path("error");
        Assert.assertEquals(error, "Not Found", "Wrong error message displayed");

    }

    @Test
    public void unfavAQuoteWithNoSession() {
        int error =
                given()
                        .headers(getHeaderWithToken())
                        .when().put(quoteId + "/unfav")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().path("error_code");

        Assert.assertTrue(error==20, "incorrect error code is displayed");

    }

    @Test
    public void unfavAQuoteUsingValidQuoteId() {

        //Create a new session before running this
                given()
                        .headers(getHeaderWithToken())
                        .when().put(quoteId + "/unfav")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .log().all();

    }
    @Test
    public void unfavAQuoteUsingInValidQuoteId() {

        //Create a new session before running this
        String error =
        given()
                .headers(getHeaderWithToken())
                .when().put(invalidQuoteId + "/unfav")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().path("error");
        Assert.assertEquals(error, "Not Found", "Wrong error message displayed");
    }

}

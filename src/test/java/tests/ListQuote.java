package tests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.ITestContext;

import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ListQuote extends BaseTest {


    @BeforeClass
    public void setPath() {
        RestAssured.basePath = "/api/quotes";

    }

    @Test(priority = 1)
    public void getListOfQuotes(ITestContext context) {
        List<String> author =
                given()
                        .headers(getHeaderWithToken())
                        .when().get()
                        .then().statusCode(HttpStatus.SC_OK)
                        .and().body("page", equalTo(1))
                        .log().all()
                        .and().extract().path("quotes.author");
        String specificAuthor = author.get(0).replaceAll(" ", "+");
        context.setAttribute("author", specificAuthor);
        System.out.println(specificAuthor);
    }


    @Test(priority = 2)
    public void getListOfQuotesByAuthor(ITestContext context) {
        String authorValue = (String) context.getAttribute("author");
        List<String> authorList =
                given()
                        .headers(getHeaderWithToken())
                        .when().get("/?filter=" + authorValue + "&type=author")
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().jsonPath().getList("quotes.author");

        Assert.assertEquals(authorList.get(0), authorValue.replaceAll("[+]", " "), "the wrong author is displayed");

    }

    @Test(priority = 3)
    public void getListOfQuotesThatContainsFunny() {
        List<String> words =
                given()
                        .headers(getHeaderWithToken())
                        .when().get("/?filter=funny")
                        .then().statusCode(HttpStatus.SC_OK)
                        .extract()
                        .path("quotes.body");

        Assert.assertTrue(words.get(0).contains("funny"));
    }

    @Test(priority = 4)
    public void getListOfQuoteWithATag() {
        List tags =
                given()
                        .headers(getHeaderWithToken())
                        .when().get("/?filter=funny&type=tag")
                        .then().statusCode(HttpStatus.SC_OK)
                        .extract()
                        .jsonPath().getList("quotes.tags");
        Assert.assertTrue(tags.toString().contains("funny"));
    }

    @Test
    public void getAllHiddenQuotes() {
        given()
                .headers(getHeaderWithToken())
                .when()
                .get("/?hidden=1")
                .then().statusCode(HttpStatus.SC_OK)
                .log().all();
    }

}

package tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;

public class BaseTest{
    String email;
    String password;
    String token = "dcd98ae3aae0555fea80382665329712";

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        RestAssured.baseURI = "https://favqs.com";

    }

    public HashMap getHeaderWithToken(){
        HashMap requestHeader = new HashMap<>();
        requestHeader.put("Authorization", "Bearer " + token);
        return requestHeader;
    }

    public HashMap getHeaderWithBadToken(){
        HashMap requestHeader = new HashMap<>();
        requestHeader.put("Authorization", "Bearer " + "");
        return requestHeader;
    }
    //private String badToken(){

   // }

    public void login(String username, String password){

    }

}

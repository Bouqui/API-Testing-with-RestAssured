package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;

public class BaseTest{
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

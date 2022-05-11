package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Random;

public class BaseTest {
    String token = "dcd98ae3aae0555fea80382665329712";

    //The BaseTest is expected to run before all tests.
    // This is where the commonly used methods are written

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        RestAssured.baseURI = "https://favqs.com";

    }

    public HashMap getHeaderWithToken() {
        HashMap requestHeader = new HashMap<>();
        requestHeader.put("Authorization", "Bearer " + token);
        return requestHeader;
    }

    public HashMap getHeaderWithBadToken() {
        HashMap requestHeader = new HashMap<>();
        requestHeader.put("Authorization", "Bearer " + generateRandomToken());
        return requestHeader;
    }

    private static String generateRandomToken() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder = stringbuilder.append(chars.charAt(rnd.nextInt(chars.length())));
        return stringbuilder.toString();
    }


}

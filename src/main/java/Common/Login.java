package Common;

import java.util.Random;

public class Login {

    public void successfulLogin(String username, String password){
        UserCreds userCreds = new UserCreds();
        userCreds.setUsername(username);
        userCreds.setPassword(password);

    }

}

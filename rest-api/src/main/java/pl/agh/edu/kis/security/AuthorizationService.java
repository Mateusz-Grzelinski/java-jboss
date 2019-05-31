package pl.agh.edu.kis.security;

import javax.inject.Singleton;
import javax.ws.rs.NotAuthorizedException;

@Singleton
public class AuthorizationService {

    public void authorize(String username, String password) throws NotAuthorizedException{
        if(!(username.equals("admin") && password.equals("admin")))
            throw new NotAuthorizedException("Invalid username or password");
    }

}

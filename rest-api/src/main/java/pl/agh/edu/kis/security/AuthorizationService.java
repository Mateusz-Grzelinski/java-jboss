package pl.agh.edu.kis.security;


import pl.agh.edu.kis.Users;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotAuthorizedException;

@Singleton
public class AuthorizationService {

    @Inject
    Users users;

    public void authorize(String username, String password) throws NotAuthorizedException{
        if(!users.getPasswordForUser(username).equals(password))
            throw new NotAuthorizedException("Invalid username or password");
    }

}

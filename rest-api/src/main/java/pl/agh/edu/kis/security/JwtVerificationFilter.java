package pl.agh.edu.kis.security;

import com.auth0.jwt.exceptions.JWTVerificationException;

import javax.inject.Inject;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@AuthenticationRequired
public class JwtVerificationFilter implements ContainerRequestFilter {

    @Inject
    AuthenticationService authenticationService;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authHeaderValue = containerRequestContext.getHeaderString("Authorization");
        try {
            String token = authHeaderValue.substring("Bearer".length()).trim();
            authenticationService.verifyToken(token);
            System.out.println("Authorized");
        } catch (JWTVerificationException e){
            System.out.println("Unauthorized");
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
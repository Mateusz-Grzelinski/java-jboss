package pl.agh.edu.kis;


import com.auth0.jwt.exceptions.JWTCreationException;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import pl.agh.edu.kis.security.AuthenticationService;
import pl.agh.edu.kis.security.AuthorizationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/auth")
@Api(value = "Authorization endpoint")
public class AuthorizationEndPoint {
    @Inject
    AuthenticationService authenticationService;
    @Inject
    AuthorizationService authorizationService;

    @GET
    @Operation(summary = "Authorize user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created token"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials")
            })
    public Response createToken(@QueryParam("username") String username,
                                @QueryParam("password") String password) {
        if (username == null || password == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("WWW-Authenticate", "Missing credentials")
                    .build();
        }

        try {
            authorizationService.authorize(username, password);
            String token = authenticationService.generateToken();
            return Response.ok(token).build();
        } catch (NotAuthorizedException e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Bearer realm=\"example\"")
                    .build();
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


}

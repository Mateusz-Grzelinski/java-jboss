package consume;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

public class ClientAuthenticationRequestFilter implements ClientRequestFilter {

    private String token;

    public ClientAuthenticationRequestFilter(String token) {
        this.token = token;
    }

    public ClientAuthenticationRequestFilter() {
        this.token = "";
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        clientRequestContext.getHeaders().add("Authorization", "Bearer " + token);
    }
}

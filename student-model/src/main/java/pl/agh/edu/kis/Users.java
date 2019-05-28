package pl.agh.edu.kis;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Users {

    private Map<String, String> users;

    public Users() {
        users = new HashMap<>();
        users.put("admin", "admin");
    }

    public String getPasswordForUser(String username){
        return users.get(username);
    }

}

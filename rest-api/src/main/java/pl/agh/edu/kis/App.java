package pl.agh.edu.kis;

import io.swagger.jaxrs.config.BeanConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class App extends Application {
    public App(){

    }
}

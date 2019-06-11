package pl.agh.edu.kis;

import io.swagger.jaxrs.config.BeanConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class App extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//        HashSet<Class<?>> s = new HashSet<Class<?>>();
//        s.add(ProtobufProvider.class);
//        s.add(App.class);
//        return s;
//    }

    public App(){

    }
}

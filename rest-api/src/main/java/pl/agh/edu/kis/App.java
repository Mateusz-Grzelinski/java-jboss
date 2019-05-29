package pl.agh.edu.kis;

import io.swagger.jaxrs.config.BeanConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class App extends Application {
    public App(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresDS");
//
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        Student student = new Student();
//        student.setName("Jack");
//        student.setSurname("Thomson");
//
//        em.persist(student);
//
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();

    }
}

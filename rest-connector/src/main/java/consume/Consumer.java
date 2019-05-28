package consume;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.agh.edu.kis.Student;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


public class Consumer {
    private static String URI = "http://localhost:8080/rest-api";
    private static String AUTHORIZE_URI = "http://localhost:8080/rest-api/auth";
    private static String STUDENTS_URI_DUMMY = "http://localhost:8080/rest-api/students/dummy";
    private static String STUDENTS_URI_DUMMY_AUTHORIZED = "http://localhost:8080/rest-api/students/dummy-authorized";
    private static String STUDENTS_URI = "http://localhost:8080/rest-api/students";

    private ResteasyClient resteasyClient;

    public Consumer() {
        resteasyClient = new ResteasyClientBuilder().build();
    }


    public void authorize() {
        ResteasyWebTarget target = resteasyClient.target(AUTHORIZE_URI)
                .queryParam("username", "admin")
                .queryParam("password", "admin");
        Response res = target.request().get();
        String token = res.readEntity(String.class);

        resteasyClient = new ResteasyClientBuilder().build();
        resteasyClient.register(new ClientAuthenticationRequestFilter(token));
    }

    public void printDummyStudent(){
        System.out.println("Getting dummy student: " + STUDENTS_URI_DUMMY);
        ResteasyWebTarget target = resteasyClient.target(STUDENTS_URI_DUMMY);
        Response response = target.request().get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();
    }

    public void printDummyStudentAuthorized(){
        System.out.println("Getting dummy student authorized: " + STUDENTS_URI_DUMMY_AUTHORIZED);
        authorize();
        ResteasyWebTarget target = resteasyClient.target(STUDENTS_URI_DUMMY_AUTHORIZED);
        Response response = target.request().get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();
    }

    public void deleteStudent(Integer id){
        System.out.println("Deleting student with id:  " + id + " : " + STUDENTS_URI + "/" + id);

        authorize();
        ResteasyWebTarget target = resteasyClient.target(STUDENTS_URI + "/" + id);
        Response response = target.request().delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();
    }

    public void addStudent(Student student){
        System.out.println("Adding student ");
        authorize();

        ResteasyWebTarget target = resteasyClient.target(STUDENTS_URI);
        Response response = target.request().post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();
    }

    public void printAllStudents(){
        System.out.println("Print all students " + STUDENTS_URI);
        ResteasyWebTarget target = resteasyClient.target(STUDENTS_URI);
        Response response = target.request().get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();
    }

    public static void main(String[] args) {
        System.out.println("Consuming REST");
        Consumer consumer = new Consumer();
        consumer.printDummyStudent();
        consumer.printDummyStudentAuthorized();

        Student student = new Student();
        student.setId(3);
        student.setName("John");
        student.setSurname("Smith");
        List<String> subjects = new ArrayList<>();
        subjects.add("IT");
        student.setSubjects(subjects);
        student.setAvatarFilepath("/home/mat/tmp.java");

        consumer.addStudent(student);
        consumer.printAllStudents();

        consumer.deleteStudent(student.getId());
        consumer.printAllStudents();
    }

}

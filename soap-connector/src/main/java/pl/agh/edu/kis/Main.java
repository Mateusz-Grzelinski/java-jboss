package pl.agh.edu.kis;

import javax.xml.ws.BindingProvider;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        HelloService service = new HelloService();
        Hello hello = service.getHelloPort();

        BindingProvider bhello = (BindingProvider) hello;
//        System.out.println(hello.helloWorld("abd"));

        bhello.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "mat");
        bhello.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "1997");

        List<String> subjects = new ArrayList<>();
        subjects.add("first subject");
        hello.createStudent("Jan", "Nowak", "/home/mat/test.txt", subjects);
        List<Student> list = hello.getAllStudents().studentAll;
        list.stream().forEach(student -> System.out.println(student.getId() + " " + student.getName()+ " "+ student.getSurname()));
        System.out.println();

    }
}

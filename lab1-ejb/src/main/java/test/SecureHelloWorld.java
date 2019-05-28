package test;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.agh.edu.kis.Student2;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@Stateless
@WebService
@SecurityDomain("my-domain")
@DeclareRoles({"specialuser"})
@WebContext(authMethod="BASIC",transportGuarantee="NONE")
public class SecureHelloWorld {

    @WebMethod
    @RolesAllowed("specialuser")
    @XmlElementWrapper(name = "StudentList")
    @XmlElement(name = "Student")
    public List Students(@WebParam(name = "name") String name, @WebParam(name = "surname") String surname) {
        List<Student2> students = new ArrayList<>();

        Student2 s = new Student2();
        s.setName(name);
        s.setSurname(surname);
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("IT");
        s.setSubjects(subjects);

        students.add(s);

        return students;
    }
}

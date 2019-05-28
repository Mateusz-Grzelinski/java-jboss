package test;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.agh.edu.kis.Student2;

import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@WebService
@Stateless
@SecurityDomain("my-domain")
@DeclareRoles({"specialuser"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
public class HelloWorld {

    @WebMethod
    public String hello(@WebParam(name = "name") String name) {
        return "Hello! " + name;
    }


    @XmlElementWrapper(name = "fancy-wrapper-name")
    @XmlElement(name = "fancy-name")
    @WebMethod
    public List Hi(@WebParam(name = "name") String name) {
        List<String> list = new ArrayList<>();
        list.add("hi" + name);
        list.add("guten morgen" + name);

        return list;
    }

    @XmlElement(name = "student")
    @WebMethod
    public Student2 FreeStudent() {
        Student2 s = new Student2();
        s.setName("Adam");
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("ITm");
        s.setSubjects(subjects);
        s.setSurname("Nowak");
        return s;
    }


}

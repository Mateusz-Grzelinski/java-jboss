package pl.agh.edu.kis;


import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Stateless
@WebService
@SecurityDomain("my-domain")
@DeclareRoles({"specialuser"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
public class Hello {
    private Random generator = new Random();
    private List<Student2> students = new ArrayList<>();

    @WebMethod
    @PermitAll
    @XmlElement(name = "HelloElement")
    public String HelloWorld(@WebParam(name = "name2") String name) {
        return "Hello " + name;
    }


    @WebMethod
    @PermitAll
    @XmlElement(name = "HelloStudent")
    public Student2 HelloStudent() {

        Student2 s = new Student2();
        s.setName("Adam" + generator.nextInt());
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("ITm");
        s.setSubjects(subjects);
        s.setSurname("Nowak" + generator.nextInt());
        return s;
    }

    @WebMethod
    @PermitAll
    public String createStudent(@WebParam(name = "name") String name,
                                @WebParam(name = "surname") String surname,
                                @WebParam(name = "avatar_filepath") String avatarFilepath,
                                @WebParam(name = "subjects") List<String> subjects) {
        Student2 new_student = new Student2();

        new_student.setName(name);
        new_student.setSurname(surname);
        new_student.setSubjects(subjects);
        new_student.setId(generator.nextInt());

        File file = new File(avatarFilepath);
        if (file.isFile())
            new_student.setAvatarFilepath(avatarFilepath);
        else
            return "Errors in filepath";

        this.students.add(new_student);
        return "Created student with id: " + new_student.getId();
    }

    @WebMethod
    @PermitAll
    @XmlElement(name = "studentGet")
    public Student2 getStudent(@WebParam(name = "id") int id) {
        for (Student2 s : this.students) {
            if (s.getId() == id)
                return s;
        }
        // TOOD: return error
        return new Student2();
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "studentList")
    @XmlElement(name = "studentAll")
    public List<Student2> getAllStudents() {
        return this.students;
    }


    @WebMethod
    @RolesAllowed("specialuser")
    @XmlElementWrapper(name = "ElementsWrapper")
    @XmlElement(name = "Element")
    public List HelloSecret(@WebParam(name = "name") String name) {

        List<String> list = new ArrayList<>();
        list.add("Hello " + name);
        list.add("Cześć " + name);
        list.add("Buenos días " + name);
        list.add("Guten Tag " + name);
        return list;
    }

}

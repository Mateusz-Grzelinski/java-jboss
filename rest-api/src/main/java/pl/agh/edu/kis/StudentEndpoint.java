package pl.agh.edu.kis;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import pl.agh.edu.kis.security.AuthenticationRequired;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/students")
@Stateless
@Api(value = "Students CRUD operations", description = "Swagger Demo")
public class StudentEndpoint {

    @Inject
    StudentDao studentDao;


    private static final Logger log = Logger.getLogger(StudentEndpoint.class.getName());

    @GET
    @Path("/dummy-authorized")
    @AuthenticationRequired
    @Operation(summary = "Dummy student with authentication",
            description = "Used for checking if authentication works"
    )
    public Response getDummyStudentAuthorized() {
        return getDummyStudent();
    }

    @GET
    @Path("/dummy")
    @Operation(summary = "Dummy student without authentication",
            description = "Used for checking if anything works"
    )
    public Response getDummyStudent() {

        Student student = new Student();
        student.setName("Roman");
        student.setSurname("Romanowski");
        Set<Subject> subjects = new HashSet<>();
        subjects.add(new Subject("Math"));
        subjects.add(new Subject("IT"));
        student.setSubjects(subjects);
//        student.setAvatarFilepath("/home/mat/tmp.java");
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("polski"));
        projects.add(new Project("angielski"));
        student.setProjects(projects);
        studentDao.create(student);

        return Response.status(Response.Status.OK).entity(student).build();
    }


    @GET
    @Operation(summary = "Get all students")
    public Response getAll(@QueryParam("name") String name, @QueryParam("project") String project) {
        List<Student> students = null;

        if (name != null)
            students = studentDao.getByField(name, project);
        else
            students = studentDao.list(0, 100);

        return Response.status(Response.Status.OK).entity(students).build();
    }

    @GET
    @Path("{id}")
    public Response getStudent(@PathParam("id") int id) {
        Student s = studentDao.get(id);
        if (s != null) {
            return Response.status(Response.Status.OK).entity(s).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
//    @AuthenticationRequired
    public Response createStudent(Student student) {
        if (student.getId() != null) {
            Student s = studentDao.get(student.getId());

            if (s != null) {
                return Response.status(Response.Status.CONFLICT).entity("This id already exists").build();
            }
        }

        studentDao.create(student);
        return Response.status(Response.Status.CREATED).entity("Student created").build();

    }

    @DELETE
    @AuthenticationRequired
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") Integer id) {
        Student s = studentDao.get(id);

        if (s == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("delete failed - no such id").build();
        }

        studentDao.delete(id);
        return Response.status(Response.Status.OK).build();

    }


}

package pl.agh.edu.kis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import pl.agh.edu.kis.exceptions.StudentNotFoundException;
import pl.agh.edu.kis.security.AuthenticationRequired;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/students")
@Api(value = "Students CRUD operations", description = "Swagger Demo")
public class StudentEndpoint {
    @Inject
    StudentDAO students;

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
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("ITm");
        student.setSubjects(subjects);
        student.setAvatarFilepath("/home/mat/tmp.java");
        return Response.status(Response.Status.OK).entity(student).build();
    }

    @GET
    @Operation(summary = "Get all students")
    public Response getAll() {
        return Response.status(Response.Status.OK).entity(students.getStudents()).build();
    }

    @GET
    @Path("{id}")
    public Response getStudent(@PathParam("id") int id) {
        try {
            Student s = students.findById(id);
            return Response.status(Response.Status.OK).entity(s).build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @AuthenticationRequired
    public Response createStudent(Student student) {
        try {
            students.add(student);
            return Response.status(Response.Status.CREATED).entity("Student created").build();
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity("This id already exists").build();
        }
    }

    @DELETE
    @AuthenticationRequired
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        try{
            students.delete(id);
            return Response.status(Response.Status.OK).build();
        } catch (StudentNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("delete failed").build();
        }
    }


}

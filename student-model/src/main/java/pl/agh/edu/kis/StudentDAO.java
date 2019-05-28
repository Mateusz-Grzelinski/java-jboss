package pl.agh.edu.kis;

import pl.agh.edu.kis.exceptions.StudentNotFoundException;

import javax.ejb.Singleton;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.*;

@Singleton
public class StudentDAO {

    @XmlElementWrapper(name = "students")
    private static Map<Integer, Student> students = new HashMap<>();

    static {
        Student student = new Student();
        student.setName("Roman");
        student.setSurname("Romanowski");
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("ITm");
        student.setSubjects(subjects);
        student.setAvatarFilepath("/home/mat/tmp.java");
        students.put(0, student);
    }


    public Student findById(final Integer id) {
        return students.get(id);
    }

    public void add(Student student) throws StudentNotFoundException {
        if (students.get(student.getId()) != null)
            throw new StudentNotFoundException("Student with id" + student.getId() + " arleady exists");

        students.put(student.getId(), student);
    }

    public synchronized void update(Student student) {
        students.replace(student.getId(), student);
    }

    public void delete(Integer id) throws StudentNotFoundException {
        if (students.get(id) == null)
            throw new StudentNotFoundException("Student with this id not be found");
        students.remove(id);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }
}


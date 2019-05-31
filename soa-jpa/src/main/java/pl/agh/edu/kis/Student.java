package pl.agh.edu.kis;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "surname")
    public String surname;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Project.class, cascade = {CascadeType.ALL, CascadeType.PERSIST})
    public List<Project> projects = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Subject.class, orphanRemoval = true, cascade = {CascadeType.ALL, CascadeType.PERSIST})
    public Set<Subject> subjects ;

    public Student() {
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String lastName) {
        this.surname = lastName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> courses) {
        this.projects = courses;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student)) return false;
        Student student = (Student) object;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", projects=" + projects +
                '}';
    }
}

package pl.agh.edu.kis;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @JsonIgnore
    @ManyToMany(targetEntity = Student.class)
    public List<Student> students = new ArrayList<>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Project)) return false;
        Project project = (Project) object;
        return Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package pl.agh.edu.kis;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @JsonIgnore
    @ManyToOne(targetEntity = Student.class)
    public Student student;

    public Subject() {
    }

    public Subject(String name) {
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
        if (!(object instanceof Subject)) return false;
        Subject project = (Subject) object;
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

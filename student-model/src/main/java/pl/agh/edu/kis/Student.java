package pl.agh.edu.kis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.io.FileUtils;

import javax.ejb.Singleton;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String surname;

    @XmlElement
    private String avatarFilepath;

    @XmlElement
    @JsonIgnore
    private String base64Avatar;

    @XmlElementWrapper
    private List<String> subjects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBase64Avatar(String base64Avatar) {
        this.base64Avatar = base64Avatar;
    }

    public String getBase64Avatar() {
        if (this.avatarFilepath == null)
            return null;

        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(this.avatarFilepath));
        } catch (IOException e) {
            System.out.println("Avatar does not exists");
        }

        return Base64.getEncoder().encodeToString(fileContent);
    }

    public String getAvatarFilepath() {
        return avatarFilepath;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                '}';
    }

    public void setAvatarFilepath(String avatarFilepath) {
        this.avatarFilepath = avatarFilepath;
    }

}

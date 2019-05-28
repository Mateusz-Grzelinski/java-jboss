package pl.agh.edu.kis;

import org.apache.commons.io.FileUtils;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SecurityDomain("my-domain")
@DeclareRoles({"specialuser"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
public class Student2 {
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElementWrapper(name = "subject-list")
    @XmlElement(name = "subject")
    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "base64Avatar")
    public String getBase64Avatar() {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(this.avatarFilepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(fileContent);
    }

    @XmlElement(name = "avatarPath")
    public String getAvatarFilepath() {
        return avatarFilepath;
    }

    public void setAvatarFilepath(String avatarFilepath) {
        this.avatarFilepath = avatarFilepath;
    }


    private int id;
    private String name;
    private String surname;

    private String avatarFilepath;

    private List<String> subjects = new ArrayList<>();

}

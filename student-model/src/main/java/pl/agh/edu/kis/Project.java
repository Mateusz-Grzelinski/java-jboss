package pl.agh.edu.kis;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    int id;
    String topic;
    String description;
}

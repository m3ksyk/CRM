package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date created;

    private String projectName;

    private String description;

    private String website; //used to validate

    private String identificator;
//    identyfikator – pole nadawane automatycznie tworzone przez usunięcie wszystkich znaków
//    diakrytycznych, np. (ółą) z pola nazwa oraz zastąpienie wszystkich białych znaków znakiem
//            myślnika,

    @OneToMany
    private List<User> assignedUsers;

    private boolean active; //inactive projects now viewed in the activity list

}

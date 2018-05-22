package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @OneToMany
    private List<User> assignedUsers;

    private boolean active;

    public void setIdentificator(String projectName) {
        this.identificator = projectName.replaceAll("\\s", "-").
                replaceAll("[^A-Za-z0-9]", "");
    }
}

package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date created;

    private String issue;

    private String description;

    private Project project;

    private Priority priority;

    private Status status;

    private User assignedUser;

}

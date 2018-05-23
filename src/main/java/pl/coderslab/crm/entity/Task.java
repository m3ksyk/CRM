package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date created;

    private String name;

    private String description;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Priority priority;
    @ManyToOne
    private Status status;

    @OneToOne
    private User assignedUser;

}

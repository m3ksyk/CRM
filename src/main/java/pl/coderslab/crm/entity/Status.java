package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private boolean active; //cant assign inactive status to task

    private int sortOrder; //used to sort statuses ??

    @OneToMany
    private List<Task> tasks;

}

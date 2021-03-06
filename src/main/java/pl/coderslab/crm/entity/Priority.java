package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private boolean active; //can't assign inactive priorities to a task

    @OneToMany
    private List<Task> tasks;
}

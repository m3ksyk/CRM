package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;
    //types: project created (description: name, who, and when)
    //       task added (description: who when and to what project, also link to task details)
    //       task status changed (description: task name, who, when, which project, also link to task details)
    private String description;

}

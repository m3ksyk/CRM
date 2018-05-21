package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String login;

    private String firstName;

    private String lastName;

    private String password; //hash before saving (add with spring security when all is working correctly)

}

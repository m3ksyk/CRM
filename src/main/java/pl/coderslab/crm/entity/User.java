package pl.coderslab.crm.entity;

import lombok.Data;
import pl.coderslab.crm.BCrypt.BCrypt;

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

    private String password;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cryptSalt;

    public void setCryptSalt(String cryptSalt) {
        this.cryptSalt = BCrypt.gensalt();
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, cryptSalt);
    }

}

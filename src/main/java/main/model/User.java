package main.model;

import lombok.Getter;
import lombok.Setter;
import main.model.enums.Role;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "is_moderator")
    private boolean isModerator;
    @Column(nullable = false, name = "reg_time")
    private Date regTime;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String code;
    @Column(columnDefinition = "TEXT")
    private String photo;

    public User(Date time, String name, String email, String password) {
        this.regTime = time;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {}

    public User(int id) {
        this.id = id;
    }

    public Role getRole() {
        return isModerator == true ? Role.MODERATOR : Role.USER;
    }
}

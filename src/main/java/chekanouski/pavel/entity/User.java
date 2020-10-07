package chekanouski.pavel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 5, max = 12, message = "Username must be more than 5 and less then 12 letters")
    private String username;

    @Column
    @Size(min = 5, max = 12, message = "Password must be more than 5 and less then 12 letters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_join_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public User(){}

    public User(Long id, @Size(min = 5, max = 12, message = "Username must be more than 5 and less then 12 letters") String username, @Size(min = 5, max = 12, message = "Password must be more than 5 and less then 12 letters") String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}

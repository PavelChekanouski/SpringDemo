package chekanouski.pavel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Role {

    @Id
    private Long id;

    @Column
    @Pattern(regexp = "^ROLE_([A-Z]{4,5})$")
    private String name;
}

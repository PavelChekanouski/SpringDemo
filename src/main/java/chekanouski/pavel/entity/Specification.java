package chekanouski.pavel.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "specifications")
@Getter
@Setter
@EqualsAndHashCode
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;


}

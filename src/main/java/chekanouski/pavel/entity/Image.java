package chekanouski.pavel.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "images")
@Getter
@Setter
@EqualsAndHashCode
public class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private long id;

    @Column(name = "image", nullable = false, updatable = false)
    private String imageURL;
}

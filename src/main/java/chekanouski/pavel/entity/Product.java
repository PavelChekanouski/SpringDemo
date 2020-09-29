package chekanouski.pavel.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter @Setter @EqualsAndHashCode
public class Product {
    @Id
    private int id;
    @Column
    private String name;
}

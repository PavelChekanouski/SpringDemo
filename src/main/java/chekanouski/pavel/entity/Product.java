package chekanouski.pavel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @OneToOne
    @JoinColumn(name= "brand_id", referencedColumnName = "id")
    public Brand brand;
    @ManyToMany
    @JoinTable(name = "products_join_specifications",
            joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specification_id", referencedColumnName = "id"))
    public List<Specification> specificationList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

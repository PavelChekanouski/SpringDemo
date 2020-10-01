package chekanouski.pavel.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public Brand brand;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "products_join_specifications",
            joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specification_id", referencedColumnName = "id"))
    public List<Specification> specificationList = new ArrayList<>();

    //!!!!!!!!!!!!!!!!!!Не работает, так как в 2 случах используется FetchType.EAGER, но по отдельности работают без проблем
    //org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: chekanouski.pavel.entity.Product.images, could not initialize proxy - no Session
    //Скорее всего проблема в том, что нет сессии. Попробую разобраться чуть позже
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "product_id")
    private List<Image> images = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name)
                && Objects.equals(brand.getName(), product.brand.getName())
                && product.specificationList.containsAll(specificationList);
    }

    @Override
    public int hashCode() {
        int value = 0;
        for (Specification specification : specificationList) {
            value += Objects.hash(specification.getSpecification());
        }
        return Objects.hash(name) + Objects.hash(brand.getName()) + value;
    }
}

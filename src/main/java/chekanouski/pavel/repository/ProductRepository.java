package chekanouski.pavel.repository;

import chekanouski.pavel.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query ("select product from Product product")
    Set<Product> getDistinct();

    @Query("select product.name, count(product.name) from Product product group by product.name")
    List<Object[]> getDistinctWithNumber();

}

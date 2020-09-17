package chekanouski.pavel.repository;

import chekanouski.pavel.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

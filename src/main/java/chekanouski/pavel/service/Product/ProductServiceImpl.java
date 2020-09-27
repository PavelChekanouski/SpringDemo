package chekanouski.pavel.service.Product;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<Product> getSetOfProducts(byte value) {

        switch (value) {
            case (1) : return new HashSet<>((List<Product>) productRepository.findAll());

            default : return productRepository.getDistinct();
        }
    }
}

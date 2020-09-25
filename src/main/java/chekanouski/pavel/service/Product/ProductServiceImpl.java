package chekanouski.pavel.service.Product;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.repository.ProductRepository;
import chekanouski.pavel.service.Product.ProductService;
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
    public Set<Product> getSetOfProducts() {
        boolean doByJava = false;
        if(doByJava){
            return new HashSet<Product>((List<Product>) productRepository.findAll());
        }
        else {
            return productRepository.getDistinct();
        }
    }
}

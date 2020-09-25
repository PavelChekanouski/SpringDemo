package chekanouski.pavel.service.ProductWithNumbers;

import chekanouski.pavel.dto.ProductWithNumbers;
import chekanouski.pavel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductWithNumbersBySQLServiceImpl implements ProductWithNumbersService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<ProductWithNumbers> getSetOfProductsWithNumbers(){
        return null;
    }
}

package chekanouski.pavel.controller;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import chekanouski.pavel.service.ProductResponse;

@RestController
@RequestMapping("/")
public class ProductController {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    //@Autowired
    //private ProductRepository productRepository;

    @GetMapping
    public ProductResponse showStatus() {
        return new ProductResponse(SUCCESS_STATUS, 1);
    }

    @GetMapping("/get")
    public ProductResponse get() {

        //Iterable<Product> products = productRepository.findAll();

        final ProductResponse response;
        String name = null;

        //for (Product product: products) {
        //    name = product.getName();
        //}

        if (name != null) {
            response = new ProductResponse(name, CODE_SUCCESS);
        } else {
            response = new ProductResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }

}

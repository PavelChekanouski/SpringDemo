package chekanouski.pavel.controller;

import chekanouski.pavel.service.ProductService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SpringConfig {
    @Bean
    public ProductService productService(){
        return new ProductService();
    }
}

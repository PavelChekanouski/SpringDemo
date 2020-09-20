package chekanouski.pavel.service;

import chekanouski.pavel.entity.Product;

import java.util.HashSet;

public class ProductResponse extends Response {

    private final String status;
    private final Integer code;
    private final HashSet set;

    public ProductResponse(String status, Integer code, HashSet set) {
        this.status = status;
        this.code = code;
        this.set = set;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public HashSet<Product> getSet() {return set;}
}

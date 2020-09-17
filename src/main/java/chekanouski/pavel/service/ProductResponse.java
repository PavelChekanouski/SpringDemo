package chekanouski.pavel.service;

public class ProductResponse {

    private final String status;
    private final Integer code;


    public ProductResponse(String status, Integer code) {
        this.status = status;
        this.code = code;

    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}

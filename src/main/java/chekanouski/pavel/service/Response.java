package chekanouski.pavel.service;

public class Response {
    private String status = "Error";
    private Integer code = 103;

    public Response() {
    }

    public Response(String status, Integer code) {
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

package demo.lwy.mysqlservice.common;

public class RetResult {

    private String returnCode;
    private String message;
    private Object data;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RetResult{" +
                "returnCode='" + returnCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

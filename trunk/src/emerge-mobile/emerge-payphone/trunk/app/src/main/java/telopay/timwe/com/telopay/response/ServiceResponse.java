package telopay.timwe.com.telopay.response;

/**
 * Created by timwe.tunji on 10/13/2016.
 */
public class ServiceResponse {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

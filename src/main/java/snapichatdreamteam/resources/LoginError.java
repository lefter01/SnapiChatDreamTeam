package snapichatdreamteam.validations;

public class LoginError {

    private int code;
    private String message;

    public LoginError() {

    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public int hashCode() {
        return code;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

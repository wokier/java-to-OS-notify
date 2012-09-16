package notify;

/**
 * Exception
 * 
 * @author francois wauquier
 * 
 */
public class UnableToNotifyException extends RuntimeException {

    public UnableToNotifyException() {
	super();
    }

    public UnableToNotifyException(String message, Throwable cause) {
	super(message, cause);
    }

    public UnableToNotifyException(String message) {
	super(message);
    }

}

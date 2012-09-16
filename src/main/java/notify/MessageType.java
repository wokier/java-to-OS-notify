package notify;

/**
 * Message types
 * 
 * @author francois wauquier
 * 
 */
public enum MessageType {
    /** An error message */
    ERROR,
    /** A warning message */
    WARNING,
    /** An information message */
    INFO,
    /** Simple message */
    NONE;

    static boolean exists(String name) {
	try {
	    valueOf(name.toUpperCase());
	    return true;
	} catch (IllegalArgumentException e) {
	    return false;
	}
    }

    static MessageType value(String name) {
	return valueOf(name.toUpperCase());
    }

}

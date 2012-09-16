package notify;

/**
 * Notifier Interface
 * 
 * @author francois wauquier
 * 
 */
public interface Notifier {

	/**
	 * Supported on this Operating System, depending on installed applications
	 * 
	 * @return
	 */
	boolean isSupported();

	/**
	 * Notify a message to the user
	 * 
	 * @param messageType
	 * @param title
	 * @param message
	 */
	void notify(MessageType messageType, String title, String message);

}

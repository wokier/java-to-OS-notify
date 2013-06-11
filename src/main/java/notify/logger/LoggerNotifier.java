package notify.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import notify.MessageType;
import notify.Notifier;
import notify.Notify;

/**
 * Java util Logging Notifier
 * 
 * @author francois wauquier
 * 
 */
public class LoggerNotifier implements Notifier {

    private static Logger LOGGER = Logger.getLogger(Notify.class.getName());

    @Override
    public boolean isSupported() {
	return true;
    }

    @Override
    public void notify(MessageType messageType, String title, String message) {
	String logMessage = title + " " + message;
	switch (messageType) {
	case NONE:
	case INFO:
	    LOGGER.log(Level.INFO, logMessage);
	    break;
	case WARNING:
	    LOGGER.log(Level.WARNING, logMessage);
	    break;
	default:
	    LOGGER.log(Level.SEVERE, logMessage);
	    break;
	}
    }
}

package notify;

import java.util.Arrays;
import java.util.List;

import notify.jre6.Jre6Notifier;
import notify.osd.OsdNotifier;
import notify.snarl.SnarlNotifier;

/**
 * To use from java<br>
 * http://stackoverflow.com/questions/3040785/fading-indicator-message-in-java <br>
 * http://www.barregren.se/blog/pop-notification-command-line <br>
 * 
 * @author fwauquier
 * 
 */
public class Notify implements Notifier {

    private static Notify instance;

    private List<Notifier> potentialNotifiers = Arrays.asList(new OsdNotifier(), // new
										 // GrowlNotifier("notify"),
	    new SnarlNotifier(), new Jre6Notifier());

    public static Notify getInstance() {
	if (instance == null) {
	    instance = new Notify();
	}
	return instance;
    }

    private Notify() {
	super();
    }

    @Override
    public boolean isSupported() {
	return true;
    }

    @Override
    public void notify(MessageType messageType, String title, String message) {
	for (Notifier notifier : potentialNotifiers) {
	    if (notifier.isSupported()) {
		notifier.notify(messageType, title, message);
		return;
	    }
	}
	throw new UnableToNotifyException("Not any notifier supported");
    }
}

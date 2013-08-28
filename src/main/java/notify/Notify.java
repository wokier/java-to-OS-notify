package notify;

import java.util.Arrays;
import java.util.List;

import notify.growl.GrowlNotifier;
import notify.jre6.Jre6Notifier;
import notify.logger.LoggerNotifier;
import notify.macosxcenter.MacOsXNotifier;
import notify.osd.OsdNotifier;
import notify.snarl.SnarlNotifier;

/**
 * To use from java<br>
 * http://stackoverflow.com/questions/3040785/fading-indicator-message-in-java <br>
 * http://www.barregren.se/blog/pop-notification-command-line <br>
 * 
 * @author francois wauquier
 * 
 */
public class Notify implements Notifier {

	private static Notify instance;

	private List<Notifier> potentialNotifiers = Arrays.asList(new OsdNotifier(), new GrowlNotifier(), new MacOsXNotifier(), new SnarlNotifier(), new Jre6Notifier());

    private  LoggerNotifier loggerNotifier = new LoggerNotifier();

	public static synchronized Notify getInstance() {
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
				break;
			}
		}
        loggerNotifier.notify(messageType,title,message);
	}

	public static void notify(String title, String message) {
		getInstance().notify(MessageType.NONE, title, message);
	}

	public static void info(String title, String message) {
		getInstance().notify(MessageType.INFO, title, message);
	}

	public static void warn(String title, String message) {
		getInstance().notify(MessageType.WARNING, title, message);

	}

	public static void error(String title, String message) {
		getInstance().notify(MessageType.ERROR, title, message);
	}

}

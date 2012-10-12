package notify.snarl;

import notify.MessageType;
import notify.Notifier;
import notify.snarl.net.Notification;
import notify.snarl.net.SnarlNetworkBridge;

public class SnarlNotifier implements Notifier {

    private static final String APPLICATION_NAME = "Maven Progress";

    @Override
    public boolean isSupported() {
	try {
	    SnarlNetworkBridge.snRegisterConfigIfNecessary(APPLICATION_NAME, "localhost");
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    @Override
    public void notify(MessageType messageType, String title, String message) {
	if (messageType == MessageType.NONE) {
	    SnarlNetworkBridge.snShowMessage(APPLICATION_NAME, title, message);
	} else {
	    String imageUrl = System.getenv("ProgramFiles(x86)") + "\\full phat\\Snarl\\etc\\icons\\" + getIconImage(messageType);
	    SnarlNetworkBridge.snShowMessage(new Notification(APPLICATION_NAME, title, message, imageUrl));
	}
    }

    private String getIconImage(MessageType messageType) {
	switch (messageType) {
	case NONE:
	case INFO:
	    return "info.png";
	case WARNING:
	    return "warning.png";
	default:
	    return "critical.png";
	}
    }

}

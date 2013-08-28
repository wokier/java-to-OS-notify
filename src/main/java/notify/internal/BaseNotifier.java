package notify.internal;

import notify.MessageType;
import notify.Notifier;

/**
 * @author francois wauquier
 */
public abstract class BaseNotifier implements Notifier {


    protected String prefix(MessageType messageType) {
        switch (messageType) {
        case NONE:
            return "";
        case INFO:
            return "! ";
        case WARNING:
            return "∆ ";
        case ERROR:
            return "☠ ";
        }
        return null;
    }
}

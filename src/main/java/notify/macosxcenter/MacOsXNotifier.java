package notify.macosxcenter;

import notify.MessageType;
import notify.Notifier;
import notify.UnableToNotifyException;
import notify.internal.BaseNotifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mac OS X Mountain Lion
 * requires https://github.com/alloy/terminal-notifier
 *
 * @author francois wauquier
 */
public class MacOsXNotifier extends BaseNotifier implements Notifier {

    private static final String TERMINAL_NOTIFIER_COMMAND = "/Applications/terminal-notifier.app/Contents/MacOS/terminal-notifier";

    @Override
    public boolean isSupported() {
        try {
            return Runtime.getRuntime().exec(TERMINAL_NOTIFIER_COMMAND+" > nil").waitFor() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void notify(MessageType messageType, String title, String message) {
        List<String> command = new ArrayList<String>();
        command.add(TERMINAL_NOTIFIER_COMMAND);
        command.add("-title");
        command.add(prefix(messageType)+title);
        command.add("-message");
        command.add(message);
        try {
            Runtime.getRuntime().exec(command.toArray(new String[command.size()]));
        } catch (IOException e) {
            throw new UnableToNotifyException("Unable to notify with Notify OSD", e);
        }
    }

}

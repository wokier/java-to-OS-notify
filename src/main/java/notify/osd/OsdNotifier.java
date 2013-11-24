package notify.osd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import notify.MessageType;
import notify.Notifier;
import notify.UnableToNotifyException;

/**
 * Notify OSD Implementation for Ubuntu<br>
 * Requires notify-send commmand<br>
 * sudo apt-get install libnotify-bin<br>
 * http://archive.ubuntu.com/ubuntu/pool/universe/libn/libnotify4/libnotify- bin_0.7.2-0ubuntu2_amd64.deb<br>
 * 
 * http://www.barregren.se/blog/pop-notification-command-line
 * 
 * 
 * @author francois wauquier
 * 
 */
public class OsdNotifier implements Notifier {

    @Override
    public boolean isSupported() {
	try {
	    return Runtime.getRuntime().exec("notify-send --help > nil").waitFor() == 0;
	} catch (Exception e) {
	    return false;
	}
    }

    @Override
    public void notify(MessageType messageType, String title, String message) {
	List<String> command = new ArrayList<String>();
	command.add("notify-send");
	switch (messageType) {
	case NONE:
	    break;
	default:
	    command.add("-i");
        //https://github.com/wokier/java-to-OS-notify/issues/2
        //command.add("gtk-dialog-" + messageType.name().toLowerCase());
        command.add("dialog-" + messageType.name().toLowerCase());
	}
	command.add(title);
	command.add(message);
	try {
	    Runtime.getRuntime().exec(command.toArray(new String[command.size()]));
	} catch (IOException e) {
	    throw new UnableToNotifyException("Unable to notify with Notify OSD", e);
	}
    }
}

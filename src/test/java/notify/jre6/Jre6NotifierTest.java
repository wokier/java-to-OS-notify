package notify.jre6;

import static org.junit.Assert.assertTrue;
import notify.MessageType;

import org.junit.Test;

public class Jre6NotifierTest {

    Jre6Notifier jre6Notifier = new Jre6Notifier();

    @Test
    public void testIsSupported() {
	assertTrue(jre6Notifier.isSupported());
    }

    @Test
    public void testNotifyMessageTypeStringString() throws Exception {
	jre6Notifier.notify(MessageType.NONE, "NONE", "none");
	Thread.sleep(6000);
	jre6Notifier.notify(MessageType.INFO, "INFO", "info");
	Thread.sleep(6000);
	jre6Notifier.notify(MessageType.WARNING, "WARNING", "warning");
	Thread.sleep(6000);
	jre6Notifier.notify(MessageType.ERROR, "ERROR", "error");
	Thread.sleep(6000);
    }

}

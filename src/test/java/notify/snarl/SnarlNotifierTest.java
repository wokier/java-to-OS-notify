package notify.snarl;

import static junit.framework.Assert.assertTrue;
import notify.MessageType;

import org.junit.Test;

public class SnarlNotifierTest {

    SnarlNotifier snarlNotifier = new SnarlNotifier();

    @Test
    public void testIsSupported() {
	assertTrue(snarlNotifier.isSupported());
    }

    @Test
    public void testNotifyMessageTypeStringString() throws Exception {
	snarlNotifier.notify(MessageType.NONE, "NONE", "none");
	Thread.sleep(1000);
	snarlNotifier.notify(MessageType.INFO, "INFO", "info");
	Thread.sleep(1000);
	snarlNotifier.notify(MessageType.WARNING, "WARNING", "warning");
	Thread.sleep(1000);
	snarlNotifier.notify(MessageType.ERROR, "ERROR", "error");
	Thread.sleep(1000);
    }

}

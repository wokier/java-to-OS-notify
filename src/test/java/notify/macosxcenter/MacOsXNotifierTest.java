package notify.macosxcenter;

import static org.junit.Assert.assertTrue;

import notify.MessageType;
import org.junit.Test;

/**
 * @author francois wauquier
 */
public class MacOsXNotifierTest {

	MacOsXNotifier macOsXNotifier = new MacOsXNotifier();

    @Test
	public void testIsSupported() throws Exception {
		assertTrue(macOsXNotifier.isSupported());
	}

    @Test
	public void testNotify() throws Exception {
		macOsXNotifier.notify(MessageType.NONE, "NONE", "none");
		Thread.sleep(2000);
		macOsXNotifier.notify(MessageType.INFO, "INFO", "info");
		Thread.sleep(2000);
		macOsXNotifier.notify(MessageType.WARNING, "WARNING", "warning");
		Thread.sleep(2000);
		macOsXNotifier.notify(MessageType.ERROR, "ERROR", "error");
		Thread.sleep(2000);
	}
}

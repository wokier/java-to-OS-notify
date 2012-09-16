package notify.growl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import notify.MessageType;

import org.junit.Ignore;
import org.junit.Test;

public class GrowlNotifierTest {

	GrowlNotifier growlNotifier = new GrowlNotifier("TEST");

	@Test
	public void testIsNotSupported() {
		assertFalse(growlNotifier.isSupported());
	}

	@Test
	@Ignore("not a mac")
	public void testIsSupported() {
		assertTrue(growlNotifier.isSupported());
	}

	@Test
	@Ignore("not a mac")
	public void testNotifyMessageTypeStringString() throws Exception {
		growlNotifier.notify(MessageType.NONE, "NONE", "none");
		Thread.sleep(1000);
		growlNotifier.notify(MessageType.INFO, "INFO", "info");
		Thread.sleep(1000);
		growlNotifier.notify(MessageType.WARNING, "WARNING", "warning");
		Thread.sleep(1000);
		growlNotifier.notify(MessageType.ERROR, "ERROR", "error");
		Thread.sleep(1000);
	}
}

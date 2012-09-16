package notify;

import org.junit.Test;

public class NotifyTest {

	@Test
	public void testNotifyMessageTypeStringString() {
		Notify.getInstance().notify(MessageType.NONE, "NONE", "none");
		Notify.getInstance().notify(MessageType.INFO, "INFO", "info");
		Notify.getInstance().notify(MessageType.WARNING, "WARNING", "warning");
		Notify.getInstance().notify(MessageType.ERROR, "ERROR", "error");
	}

}

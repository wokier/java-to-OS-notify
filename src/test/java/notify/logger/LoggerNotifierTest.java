package notify.logger;

import static org.junit.Assert.assertTrue;
import notify.MessageType;

import org.junit.Test;

public class LoggerNotifierTest {

    LoggerNotifier loggerNotifier = new LoggerNotifier();

    @Test
    public void testIsSupported() {
	assertTrue(loggerNotifier.isSupported());
    }

    @Test
    public void testNotifyMessageTypeStringString() throws Exception {
	loggerNotifier.notify(MessageType.NONE, "NONE", "none");
	loggerNotifier.notify(MessageType.INFO, "INFO", "info");
	loggerNotifier.notify(MessageType.WARNING, "WARNING", "warning");
	loggerNotifier.notify(MessageType.ERROR, "ERROR", "error");
    }

}

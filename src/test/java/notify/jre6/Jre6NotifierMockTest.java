package notify.jre6;

import static org.junit.Assert.assertFalse;

import java.awt.SystemTray;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Jre6Notifier.class, SystemTray.class })
public class Jre6NotifierMockTest {

    Jre6Notifier jre6Notifier = new Jre6Notifier();

    @Test
    public void testIsNotSupportedOnAppengine() {
	PowerMock.mockStatic(SystemTray.class);
	EasyMock.expect(SystemTray.isSupported()).andThrow(new NoClassDefFoundError());
	PowerMock.replay(SystemTray.class);

	assertFalse(jre6Notifier.isSupported());
    }
}

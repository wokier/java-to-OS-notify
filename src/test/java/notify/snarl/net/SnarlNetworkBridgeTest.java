package notify.snarl.net;

import org.junit.Test;

public class SnarlNetworkBridgeTest {

    @Test
    public void testShowMessage() throws Exception {
	SnarlNetworkBridge.snRegisterConfig("Maven Progress", "localhost");
	SnarlNetworkBridge.snShowMessage("Maven Progress", "title", "content");
	SnarlNetworkBridge.snRevokeConfig();
    }

    @Test
    public void testIcon() throws Exception {
	SnarlNetworkBridge.snRegisterConfig("Maven Progress Icon", "localhost");
	SnarlNetworkBridge.snShowMessage(new Notification("Maven Progress Icon", "title", "content", "C:\\Program Files (x86)\\full phat\\Snarl\\etc\\icons\\bad.png"));
	SnarlNetworkBridge.snRevokeConfig();

    }
}

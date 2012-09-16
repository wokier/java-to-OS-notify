package notify;

import org.junit.Test;

public class MainTest {

    Main main = new Main();

    @Test
    public void test() {
	main.notify(new String[] { "TITLE", "message" });
	main.notify(new String[] { "NONE", "NONE", "none" });
	main.notify(new String[] { "INFO", "INFO", "info" });
	main.notify(new String[] { "WARNING", "WARNING", "warning" });
	main.notify(new String[] { "ERROR", "ERROR", "error" });
	main.notify(new String[] { "error", "error", "error" });
    }

}

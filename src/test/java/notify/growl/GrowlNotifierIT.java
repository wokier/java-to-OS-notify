package notify.growl;

import org.junit.*;

import static org.junit.Assert.assertFalse;

/**
 * @author alex.collins
 */
public class GrowlNotifierIT {
    @Test
    public void testIsSupported() throws Exception {
        assertFalse(new GrowlNotifier().isSupported());
    }
}

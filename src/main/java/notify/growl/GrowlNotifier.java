package notify.growl;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import notify.MessageType;
import notify.Notifier;
import notify.UnableToNotifyException;

/**
 * Notify with Growl using AppleScript and Java Script engine.
 * 
 * @see http ://www.jayway.com/2011/04/12/send-growl-notifications-on-os-x-using-a -java-6-script-engine-and-applescript/
 * 
 * @author Tobias S??dergren, Jayway
 * @author francois wauquier
 */
public class GrowlNotifier implements Notifier {

    private static final String GROWL_APPLICATION = "GrowlHelperApp";

    private static final String APPLICATION_NAME = "NOTIFY";

    private ScriptEngine appleScriptEngine;

    private boolean registered;

    public GrowlNotifier() {
	this.appleScriptEngine = createScriptEngine();
    }

    public ScriptEngine createScriptEngine() {
	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	ScriptEngine appleScriptEngine = scriptEngineManager.getEngineByName("AppleScript");
	return appleScriptEngine;
    }

    public void registerApplication(String[] notifications) throws ScriptException {
	String script = script().add("tell application ").quote(GROWL_APPLICATION).nextRow("set the availableList to ").array(notifications).nextRow("set the enabledList to ").array(notifications)
		.nextRow("register as application ").quote(APPLICATION_NAME).add(" all notifications availableList default notifications enabledList").nextRow("end tell").get();
	executeScript(script);
    }

    @Override
    public boolean isSupported() {
	registerIfNecessary();
	return appleScriptEngine != null && isGrowlEnabled();
    }

    @Override
    public void notify(MessageType messageType, String title, String message) {
	registerIfNecessary();
	notify(messageType.name(), prefix(messageType) + title, message);
    }

    private String prefix(MessageType messageType) {
	switch (messageType) {
	case NONE:
	    return "";
	case INFO:
	    return "? ";
	case WARNING:
	    return "? ";
	case ERROR:
	    return "? ";
	}
	return null;
    }

    private void registerIfNecessary() {
	if (!registered) {
	    if (appleScriptEngine == null) {
		throw new IllegalStateException("You are trying to notify with Growl on a non-supported OS");
	    }
	    try {
		registerApplication(new String[] { "NONE", "INFO", "WARNING", "ERROR" });
	    } catch (ScriptException e) {
		throw new UnableToNotifyException("Unable to register Growl Application", e);
	    }
	    registered = true;
	}
    }

    public void notify(String notificationName, String title, String message) {
	String script = script().add("tell application ").quote(GROWL_APPLICATION).nextRow("notify with name ").quote(notificationName).add(" title ").quote(title).add(" description ").quote(message)
		.add(" application name ").quote(APPLICATION_NAME).nextRow("end tell").get();
	try {
	    executeScript(script);
	} catch (ScriptException e) {
	    throw new UnableToNotifyException("Unable to notify with Growl", e);
	}
    }

    private boolean isGrowlEnabled() {
	String script = script().add("tell application ").quote("System Events").nextRow("return count of (every process whose name is ").quote(GROWL_APPLICATION).add(") > 0").nextRow("end tell")
		.get();
	long count = executeScript(script, 0L);
	return count > 0;
    }

    @SuppressWarnings("unchecked")
    private <T> T executeScript(String script, T defaultValue) {
	try {
	    return (T) appleScriptEngine.eval(script, appleScriptEngine.getContext());
	} catch (ScriptException e) {
	    return defaultValue;
	}
    }

    private void executeScript(String script) throws ScriptException {
	appleScriptEngine.eval(script, appleScriptEngine.getContext());
    }

    private AppleScriptBuilder script() {
	return new AppleScriptBuilder();
    }
}
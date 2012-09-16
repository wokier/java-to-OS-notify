package notify;

/**
 * mainClass used for an executable jar
 * 
 * @author francois wauquier
 * 
 */
public class Main {

    public static void main(String[] args) throws Exception {
	int exitStatus = new Main().notify(args);
	Thread.sleep(2000);
	System.exit(exitStatus);
    }

    protected Main() {
	super();
    }

    protected int notify(String[] args) {
	if (args.length == 2 && !MessageType.exists(args[0])) {
	    Notify.getInstance().notify(MessageType.NONE, args[0], args[1]);
	    return 0;
	}
	if (args.length != 3 || !MessageType.exists(args[0])) {
	    usage();
	    return 1;
	}
	Notify.getInstance().notify(MessageType.value(args[0]), args[1], args[2]);
	return 0;
    }

    private void usage() {
	System.err.print("Usage: java -jar java-to-OS-notify-VERSION.jar [INFO|WARNING|ERROR]? title message");
    }

}

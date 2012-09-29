package notify.snarl.net;

/**
 * A Snarl Notification, Containing Reply, Action and Notification ID
 * 
 * @author Patrick von Reth
 * 
 * 
 */

public class Notification extends Message {
	private int id = -1;
	private SNPActionListener actionListener = null;
	private Action userAction = null;

	/**
	 * Creates a new Default Notification with SnarlNetworkBridge default
	 * timeout
	 * 
	 * @param alert
	 *            the name of the alert class
	 * @param title
	 *            the title of the Notification
	 * @param content
	 *            the content of the Notification
	 * @param iconUrl
	 *            the http url to the icon
	 */
	public Notification(String alert, String title, String content,
			String iconUrl) {
		super("notification", new SNPProperty[] {
				SnarlNetworkBridge.appName,
				new SNPProperty("class", alert),
				new SNPProperty("title", title),
				new SNPProperty("text", content),
				new SNPProperty("icon", iconUrl),
				new SNPProperty("timeout", String.valueOf(SnarlNetworkBridge
						.snGetTimeout())) });
	}

	/**
	 * Creates a new Default Notification
	 * 
	 * @param alert
	 *            the name of the alert class
	 * @param title
	 *            the title of the Notification
	 * @param content
	 *            the content of the Notification
	 * @param iconUrl
	 *            the http url to the icon
	 * @param timeout
	 *            the timeout of the Notification
	 * 
	 */
	public Notification(String alert, String title, String content,
			String iconUrl, int timeout) {
		super("notification", new SNPProperty[] {
				SnarlNetworkBridge.appName,
				new SNPProperty("class", alert),
				new SNPProperty("title", title),
				new SNPProperty("text", content),
				new SNPProperty("icon", iconUrl),
				new SNPProperty("timeout", String.valueOf(timeout)) });

	}

	/**
	 * Sets the action which the user applied
	 * 
	 * @param action
	 *            the Action to be set
	 * 
	 */
	void setUserAction(Action action) {
		this.userAction = action;
		if (action == Action.Closed || action == Action.LeftClicked
				|| action == Action.Timed_Out)
			SnarlNetworkBridge.removeNotification(this);
		if (actionListener == null)
			return;
		switch (action) {
		case LeftClicked:
			actionListener.notificationLeftClicked();
			break;
		case RhigthClicked:
			actionListener.notificationRightClicked();
			break;
		case Closed:
			actionListener.notificationClosed();
			break;
		case Timed_Out:
			actionListener.notificationTimedOut();
		default:
			break;
		}
	}

	/**
	 * Get the Action which the user applied, or null if nothing set
	 * 
	 * @return the Action of the Notification
	 */
	public Action getUserAction() {
		return userAction;
	}

	/**
	 * Sets the id of the Notification called by SnarlNetworkBridge
	 * 
	 * @param id
	 *            the id to be set
	 */
	void setId(String id) {
		this.id = Integer.valueOf(id);
	}

	/**
	 * Returns the Snarl Notification Id
	 * 
	 * @return id of the Notification
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the SNPActionListener
	 * 
	 * @param actionListener
	 *            the ActionListener to be set
	 */
	public void setActionListener(SNPActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/**
	 * Returns the SNPActionlistener
	 * 
	 * @return the current ActionListner or null
	 */
	public SNPActionListener getActionListener() {
		return actionListener;
	}

}

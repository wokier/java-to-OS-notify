package notify.snarl.net;

public interface SNPActionListener {
	/**
	 * Called if the Notification was left clicked
	 */
	public void notificationLeftClicked();

	/**
	 * Called if the Notification was right clicked
	 */
	public void notificationRightClicked();

	/**
	 * Called if the Notification was closed by the user
	 */
	public void notificationClosed();

	/**
	 * Called if the Notification timed out
	 */
	public void notificationTimedOut();

}

package notify.snarl.net;

/**
 * Enumeration of all user actions which can be applied to a Snarl Notification
 * 
 * @author Patrick von Reth
 * 
 * 
 */
public enum Action {

	RhigthClicked(302), Timed_Out(303), LeftClicked(304), Closed(307);

	private int code;

	private Action(int code) {
		this.code = code;
	}

	/**
	 * Returns the enum constant of this type with the specified code.
	 * 
	 * @param code
	 *            the Code of the enum constant to be returned
	 * @return the eum constant with the specific code
	 */
	public static Action getByCode(int code) {
		for (Action a : Action.values())
			if (a.code == code)
				return a;
		return Timed_Out;
	}

	/**
	 * Returns the code of the specific enum constant
	 * 
	 * @return the code of the enum constant
	 */
	public int getCode() {
		return code;
	}
}

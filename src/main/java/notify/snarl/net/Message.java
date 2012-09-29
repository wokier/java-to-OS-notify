package notify.snarl.net;

/**
 * 
 * A snarl Message containing Message and Snarl Reply
 * 
 * @author Patrick von Reth
 * 
 * 
 */
public class Message {

	private Reply reply = null;
	private SNPProperty msg[] = null;
	/**
	 * the SNP action(notification,register...);
	 */
	protected SNPProperty action = new SNPProperty("action");

	/**
	 * The Constructor of a Snarl Message
	 * 
	 * @param propertys
	 *            an aray  of {@link SNPProperty}s 
	 */
	public Message(String action, SNPProperty[] propertys) {
		this.msg = propertys;
		this.action.setValue(action);
	}

	/**
	 * The Constructor of a Snarl Message
	 * 
	 * @param property the {@link SNPProperty} of the message
	 */
	public Message(String action, SNPProperty property) {
		this.action.setValue(action);
		this.msg = new SNPProperty[] { property };
	}



	/**
	 * Returns the Reply of Snarl if set, otherwise null
	 * 
	 * @return the Reply of the Message
	 */
	public Reply getReply() {
		return reply;
	}

	/**
	 * Called by SnarlNetworkBridge to set the Snarl Reply
	 * 
	 * @param reply
	 *            the Reply which is to be set
	 */
	void setReply(Reply reply) {
		this.reply = reply;
	}

	/**
	 * Returns the SNP String
	 */
	public String toString() {
		String out = SnarlNetworkBridge.head + action;
		for (SNPProperty p : msg) {
			out += p;
		}
		return out+"\r\n";
	}

	
}

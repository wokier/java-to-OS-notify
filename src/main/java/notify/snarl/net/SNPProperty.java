package notify.snarl.net;

public class SNPProperty {
	private String name = null;
	private String value = null;

	/**
	 * Creates a new SNP Property containing name and value
	 * 
	 * @param name
	 *            the name of the Property
	 * @param value
	 *            the value of the Property
	 */
	public SNPProperty(String name, String value) {
		this.name = name;
		if (value!=null&&!value.equals(""))
			this.value = value;

	}

	/**
	 * Creates a new SNP Property containing name
	 * 
	 * @param name
	 *            the name of the Property
	 */

	public SNPProperty(String name) {
		this.name = name;
	}

	/**
	 * Sets the value of a property
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Returns the name of the property
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the value of the Property
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		if (value == null)
			return "";
		return "#?" + name + "=" + value ;
	}
}

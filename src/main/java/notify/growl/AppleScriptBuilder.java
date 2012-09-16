package notify.growl;

/**
 * Apple Script Fluent Builder
 * 
 * @author Tobias Södergren, Jayway
 * @author francois wauquier
 * 
 */
class AppleScriptBuilder {

	private StringBuilder builder = new StringBuilder();

	protected AppleScriptBuilder() {
		super();
	}

	public AppleScriptBuilder add(String text) {
		builder.append(text);
		return this;
	}

	public AppleScriptBuilder quote(String text) {
		builder.append("\"");
		builder.append(text);
		builder.append("\"");
		return this;
	}

	public AppleScriptBuilder nextRow(String text) {
		builder.append("\n");
		builder.append(text);
		return this;
	}

	public String get() {
		return builder.toString();
	}

	public AppleScriptBuilder array(String[] array) {
		builder.append("{");
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				builder.append(", ");
			}
			quote(array[i]);
		}
		builder.append("}");
		return this;
	}
}
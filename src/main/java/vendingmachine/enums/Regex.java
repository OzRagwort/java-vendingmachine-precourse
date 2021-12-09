package vendingmachine.enums;

public enum Regex {
	PRODUCT_REGEX("\\[(.*),([0-9]*),([0-9]*)]");

	private final String regex;

	Regex(String regex) {
		this.regex = regex;
	}

	public String get() {
		return regex;
	}
}

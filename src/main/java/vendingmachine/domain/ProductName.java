package vendingmachine.domain;

public class ProductName {
	private String name;

	public ProductName(String input) {
		this.name = input;
	}

	public String get() {
		return name;
	}
}

package vendingmachine.domain;

public class Quantity {
	private int quantity;

	public Quantity(String input) {
		this.quantity = Integer.parseInt(input);
	}

	public Quantity(int quantity) {
		this.quantity = quantity;
	}

	public int get() {
		return quantity;
	}

	public void add(Quantity quotient) {
		this.quantity += quotient.quantity;
	}

	public int mul(int amount) {
		return amount * quantity;
	}
}

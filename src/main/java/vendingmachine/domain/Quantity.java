package vendingmachine.domain;

public class Quantity {
	private static final int EMPTY_VALUE = 0;

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

	public void sub(Quantity quantity) {
		this.quantity -= quantity.quantity;
	}

	public int mul(int amount) {
		return amount * quantity;
	}

	public boolean isEmpty() {
		return quantity == EMPTY_VALUE;
	}
}

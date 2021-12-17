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

	public static Quantity min(Quantity a, Quantity b) {
		if (a.quantity <= b.quantity) {
			return a;
		}
		return b;
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

	public boolean isEmpty() {
		return quantity == EMPTY_VALUE;
	}
}

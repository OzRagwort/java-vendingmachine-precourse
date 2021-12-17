package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Quantity {
	private static final int EMPTY_VALUE = 0;

	private int quantity;

	public Quantity(String input) {
		validateNumberFormat(input);
		int integerInput = Integer.parseInt(input);
		validateNegative(integerInput);
		this.quantity = integerInput;
	}

	public Quantity(int quantity) {
		validateNegative(quantity);
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

	private void validateNumberFormat(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(QUANTITY_NUMBER_FORMAT_ERROR.get());
		}
	}

	private void validateNegative(int integerInput) {
		if (integerInput < 0) {
			throw new IllegalArgumentException(QUANTITY_LOWER_THEN_ZERO_ERROR.get());
		}
	}
}

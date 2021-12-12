package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Quantity {
	private static final int SOLD_OUT = 0;
	private static final int EMPTY_QUANTITY = 0;

	private int quantity;

	public Quantity(String value) {
		validateNumberFormat(value);
		int quantity = Integer.parseInt(value);
		validateRange(quantity);
		this.quantity = quantity;
	}

	public Quantity(int quantity) {
		this.quantity = quantity;
	}

	public int get() {
		return quantity;
	}

	public void add(int quantity) {
		this.quantity += quantity;
	}

	public void sub(int quantity) {
		this.quantity -= quantity;
	}

	public boolean has() {
		return quantity > EMPTY_QUANTITY;
	}

	public boolean isSoldOut() {
		return quantity == SOLD_OUT;
	}

	private void validateNumberFormat(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(QUANTITY_NOT_NUMBER_ERROR_MESSAGE.get());
		}
	}

	private void validateRange(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(QUANTITY_LOWER_THEN_ZERO_ERROR_MESSAGE.get());
		}
	}
}

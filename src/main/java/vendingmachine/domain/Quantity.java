package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import vendingmachine.enums.ErrorMessage;

public class Quantity {
	private final int quantity;

	public Quantity(String value) {
		validateNumberFormat(value);
		int quantity = Integer.parseInt(value);
		validateRange(quantity);
		this.quantity = quantity;
	}

	public int get() {
		return quantity;
	}

	private void validateNumberFormat(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(QUANTITY_NUMBER_FORMAT_ERROR_MESSAGE.get());
		}
	}

	private void validateRange(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(QUANTITY_NEGATIVE_NUMBER_MESSAGE.get());
		}
	}
}

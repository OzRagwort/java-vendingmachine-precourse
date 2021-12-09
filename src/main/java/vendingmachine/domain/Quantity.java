package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Quantity {
	private int quantity;

	public Quantity(String quantity) {
		validateNumberFormat(quantity);
		validateRange(Integer.parseInt(quantity));
		this.quantity = Integer.parseInt(quantity);
	}

	public int get() {
		return quantity;
	}

	private void validateNumberFormat(final String quantity) {
		try {
			Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(QUANTITY_NUMBER_FORMAT_ERROR_MESSAGE.get());
		}
	}

	private void validateRange(final int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(QUANTITY_NEGATIVE_NUMBER_ERROR_MESSAGE.get());
		}
	}
}

package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Price extends Amount {
	private static final int MINIMUM_PRICE = 100;

	private int price;

	public Price(String value) {
		super(value);
		validateMinimumPrice();
	}

	public int get() {
		return price;
	}

	private void validateMinimumPrice() {
		if (price < MINIMUM_PRICE) {
			throw new IllegalArgumentException(PRICE_LOWER_THEN_MINIMUM_PRICE_ERROR_MESSAGE.get());
		}
	}
}

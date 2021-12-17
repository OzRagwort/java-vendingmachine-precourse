package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Product {
	private static final int MINIMUM_PRICE = 100;

	private Name name;
	private Money price;
	private Quantity quantity;

	public Product(Name name, Money price, Quantity quantity) {
		validateMinimumPrice(price);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	private void validateMinimumPrice(Money price) {
		if (price.underThan(MINIMUM_PRICE)) {
			throw new IllegalArgumentException(PRICE_UNDER_THAN_MINIMUM_PRICE_ERROR.get());
		}
	}
}

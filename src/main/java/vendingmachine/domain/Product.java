package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Product {
	private static final int MINIMUM_PRICE = 100;
	private static final Quantity QUANTITY_ONE = new Quantity("1");

	private Name name;
	private Money price;
	private Quantity quantity;

	public Product(Name name, Money price, Quantity quantity) {
		validateMinimumPrice(price);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Money getPrice() {
		return price;
	}

	public void sell() {
		quantity.sub(QUANTITY_ONE);
	}

	public boolean isSoldOut() {
		return quantity.isEmpty();
	}

	public boolean isSameName(Name name) {
		return this.name.isSame(name);
	}

	public boolean canSell(Money money) {
		if (isSoldOut()) {
			return false;
		}
		return money.moreThan(price.get());
	}

	private void validateMinimumPrice(Money price) {
		if (price.underThan(MINIMUM_PRICE)) {
			throw new IllegalArgumentException(PRICE_UNDER_THAN_MINIMUM_PRICE_ERROR.get());
		}
	}
}

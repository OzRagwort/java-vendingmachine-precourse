package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;
import static vendingmachine.enums.Regex.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	private static final String REGEX = PRODUCT_REGEX.get();
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	private static final int NAME_POSITION = 1;
	private static final int PRICE_POSITION = 2;
	private static final int QUANTITY_POSITION = 3;
	private static final int MINIMUM_PRICE = 100;

	private String name;
	private int price;
	private int quantity;

	public Product(final String input) {
		Matcher matcher = PATTERN.matcher(input);
		if (matcher.find()) {
			String name = new Name(matcher.group(NAME_POSITION)).get();
			int price = new Amount(matcher.group(PRICE_POSITION)).get();
			int quantity = new Quantity(matcher.group(QUANTITY_POSITION)).get();
			validatePrice(price);
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}
	}

	public String getName() {
		return name;
	}

	private void validatePrice(final int price) {
		if (price < MINIMUM_PRICE) {
			throw new IllegalArgumentException(LOWER_THAN_MINIMUM_PRICE_ERROR_MESSAGE.get());
		}
	}
}

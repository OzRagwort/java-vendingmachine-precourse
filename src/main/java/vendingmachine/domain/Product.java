package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.enums.Coin;

public class Product {
	private static final int MIN_PRICE = 100;
	private static final int MIN_QUANTITY = 0;

	private String name;
	private int price;
	private int quantity;

	public Product(final String input) {
		String regex = "^\\[(.*),([0-9]*),([0-9]*)]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		validateFormat(input, regex);
		if (matcher.find()) {
			name = matcher.group(1);
			price = Integer.parseInt(matcher.group(2));
			quantity = Integer.parseInt(matcher.group(3));
			validatePrice(price);
			validateQuantity(quantity);
		}
	}

	private void validateFormat(String input, String regex) {
		if (!input.matches(regex)) {
			throw new IllegalArgumentException(PRODUCT_FORMAT_ERROR_MESSAGE.get());
		}
	}

	private void validatePrice(int price) {
		if (price < MIN_PRICE) {
			throw new IllegalArgumentException(LOWER_THAN_MINIMUM_PRICE_ERROR_MESSAGE.get());
		}
		if (price % Coin.COIN_10.get() != 0) {
			throw new IllegalArgumentException(NOT_DIVISIBLE_BY_COIN_10_ERROR_MESSAGE.get());
		}
	}

	private void validateQuantity(int quantity) {
		if (quantity < MIN_QUANTITY) {
			throw new IllegalArgumentException(LOWER_THAN_ZERO_QUANTITY_ERROR_MESSAGE.get());
		}
	}
}

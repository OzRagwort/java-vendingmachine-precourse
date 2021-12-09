package vendingmachine.domain;

import static vendingmachine.enums.Regex.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	private static final String REGEX = PRODUCT_REGEX.get();
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	private static final int NAME_POSITION = 1;
	private static final int PRICE_POSITION = 2;
	private static final int QUANTITY_POSITION = 3;

	private String name;
	private int price;
	private int quantity;

	public Product(final String input) {
		Matcher matcher = PATTERN.matcher(input);
		if (matcher.find()) {
			this.name = matcher.group(NAME_POSITION);
			this.price = Integer.parseInt(matcher.group(PRICE_POSITION));
			this.quantity = Integer.parseInt(matcher.group(QUANTITY_POSITION));
		}
	}
}

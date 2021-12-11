package vendingmachine.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	private static final int NO_QUANTITY_COUNT = 0;
	private String name;
	private int price;
	private int quantity;

	public Product(String input, Pattern pattern) {
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			name = matcher.group(1);
			price = Integer.parseInt(matcher.group(2));
			quantity = Integer.parseInt(matcher.group(3));
		}
	}

	public String getName() {
		return name;
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public boolean isSameQuantity(int quantity) {
		return this.quantity == quantity;
	}

	public boolean canSell(int money) {
		if (quantity == NO_QUANTITY_COUNT) {
			return false;
		}
		if (money < price) {
			return false;
		}
		return true;
	}

	public int sell() {
		quantity--;
		return price;
	}
}

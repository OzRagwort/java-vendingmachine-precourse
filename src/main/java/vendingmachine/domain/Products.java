package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Products {
	private static final String SEPARATOR = ";";
	private static final String REGEX = "\\[(.+),([0-9]+),([0-9]+)]";
	private static final Pattern PATTERN = Pattern.compile(REGEX);

	private List<Product> products = new ArrayList<>();

	public Products(String input) {
		String[] inputs = input.split(SEPARATOR);
		for (String productString : inputs) {
			Product product = makeProduct(productString);
			products.add(product);
		}
	}

	private Product makeProduct(String productString) {
		Matcher matcher = PATTERN.matcher(productString);
		if (matcher.find()) {
			Name name = new Name(matcher.group(1));
			Money price = new Money(matcher.group(2));
			Quantity quantity = new Quantity(matcher.group(3));
			return new Product(name, price, quantity);
		}
		throw new IllegalArgumentException(PRODUCT_PATTERN_ERROR.get());
	}
}

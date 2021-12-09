package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;
import static vendingmachine.enums.Regex.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Products {
	private static final String SEPARATOR = ";";
	private static final String REGEX = PRODUCT_REGEX.get();
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	private static final int NAME_POSITION = 1;

	private final List<Product> products;

	public Products() {
		products = new ArrayList<>();
	}

	public void add(final String inputProductString) {
		String[] inputs = inputProductString.split(SEPARATOR);
		List<Product> productBuffer = new ArrayList<>();
		for (String input : inputs) {
			validateFormat(input);
			validateDuplicate(input);
			productBuffer.add(new Product(input));
		}
		products.addAll(productBuffer);
	}

	private List<String> getProductNames() {
		return products.stream()
			.map(Product::getName)
			.collect(Collectors.toList());
	}

	private void validateFormat(final String product) {
		if (!product.matches(REGEX)) {
			throw new IllegalArgumentException(PRODUCT_FORMAT_ERROR_MESSAGE.get());
		}
	}

	private void validateDuplicate(final String input) {
		Matcher matcher = PATTERN.matcher(input);
		if (!matcher.find()) {
			throw new IllegalArgumentException(PRODUCT_FORMAT_ERROR_MESSAGE.get());
		}
		String name = matcher.group(NAME_POSITION);
		if (getProductNames().contains(name)) {
			throw new IllegalArgumentException(PRODUCT_REGISTERED_ERROR_MESSAGE.get());
		}
	}
}

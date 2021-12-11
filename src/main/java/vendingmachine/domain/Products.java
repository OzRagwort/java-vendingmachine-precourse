package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Products {
	private static final String SEPARATOR = ";";
	private static final String REGEX = "\\[(.*),([0-9]*),([0-9]*)]";
	private static final Pattern PATTERN = Pattern.compile(REGEX);

	List<Product> products = new ArrayList<>();

	public Products() {
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addByString(String inputMessage) {
		String[] inputs = inputMessage.split(SEPARATOR);
		for (String input : inputs) {
			products.add(new Product(input, PATTERN));
		}
	}

	public void addAll(Products newProducts) {
		products.addAll(newProducts.products);
	}
}

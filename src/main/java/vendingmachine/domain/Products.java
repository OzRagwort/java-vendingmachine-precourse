package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private static final String SEPARATOR = ";";

	private List<Product> products;

	public Products() {
		products = new ArrayList<>();
	}

	public void add(final String inputProductString) {
		String[] inputs = inputProductString.split(SEPARATOR);
		for (String input : inputs) {
			products.add(new Product(input));
		}
	}
}

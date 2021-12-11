package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

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
		validateFormat(inputs);
		for (String input : inputs) {
			products.add(new Product(input, PATTERN));
		}
	}

	public boolean canRegister(Products newProducts) {
		for (Product product : newProducts.products) {
			if (products.stream().anyMatch(p -> p.isSameName(product))) {
				throw new IllegalArgumentException(REGISTERED_PRODUCT_NAME_ERROR_MESSAGE.get());
			}
		}
		return true;
	}

	public void registerAll(Products newProducts) {
		products.addAll(newProducts.products);
	}

	public boolean canSell(int inputMoney) {
		return products.stream()
			.anyMatch(product -> product.canSell(inputMoney));
	}

	public int sellProduct(ProductName name, int inputMoney) {
		Product product = products.stream()
			.filter(p -> p.isSameName(name.get()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NO_PRODUCT_ERROR_MESSAGE.get()));
		if (product.canSell(inputMoney)) {
			inputMoney -= product.sell();
		}
		return inputMoney;
	}

	private void validateFormat(String[] inputs) {
		for (String input : inputs) {
			if (!input.matches(REGEX)) {
				throw new IllegalArgumentException(PRODUCT_INPUT_FORMAT_ERROR_MESSAGE.get());
			}
		}
	}
}

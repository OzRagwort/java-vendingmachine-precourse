package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	private final List<Product> products = new ArrayList<>();

	public ProductRepository() {
		clear();
	}

	public void add(Product product) {
		validateRegistered(product);
		this.products.add(product);
	}

	public void addAll(Products products) {
		validateRegistered(products);
		this.products.addAll(products.getProducts());
	}

	public void clear() {
		products.clear();
	}

	public void validateRegistered(Products products) {
		if (products.anyMatch(this.products)) {
			throw new IllegalArgumentException(ALREADY_REGISTERED_PRODUCT_ERROR.get());
		}
	}

	public void validateRegistered(Product product) {
		if (this.products.contains(product)) {
			throw new IllegalArgumentException(ALREADY_REGISTERED_PRODUCT_ERROR.get());
		}
	}
}

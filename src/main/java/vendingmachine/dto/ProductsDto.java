package vendingmachine.dto;

import vendingmachine.domain.Products;

public class ProductsDto {
	private Products products;

	public ProductsDto(Products products) {
		this.products = products;
	}

	public Products getProducts() {
		return products;
	}
}

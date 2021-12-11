package vendingmachine.dto;

import vendingmachine.domain.Products;

public class AddProductsDto {
	private Products products;
	private Products newProducts;

	public AddProductsDto(Products products, Products newProducts) {
		this.products = products;
		this.newProducts = newProducts;
	}

	public Products getProducts() {
		return products;
	}

	public Products getNewProducts() {
		return newProducts;
	}
}

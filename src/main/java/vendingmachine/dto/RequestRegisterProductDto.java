package vendingmachine.dto;

import vendingmachine.domain.Products;

public class RequestRegisterProductDto {
	private Products products;

	public RequestRegisterProductDto(Products products) {
		this.products = products;
	}

	public Products getProducts() {
		return products;
	}
}

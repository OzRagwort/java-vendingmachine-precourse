package vendingmachine.dto;

import vendingmachine.domain.ProductName;
import vendingmachine.domain.Products;

public class SellProductDto {
	private Products products;
	private ProductName name;
	private int inputMoney;

	public SellProductDto(Products products, ProductName productName, int inputMoney) {
		this.products = products;
		this.name = productName;
		this.inputMoney = inputMoney;
	}

	public Products getProducts() {
		return products;
	}

	public ProductName getName() {
		return name;
	}

	public int getInputMoney() {
		return inputMoney;
	}
}

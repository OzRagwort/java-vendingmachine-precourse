package vendingmachine.dto;

import vendingmachine.domain.Products;

public class CanSellDto {
	private Products products;
	private int inputMoney;

	public CanSellDto(Products products, int inputMoney) {
		this.products = products;
		this.inputMoney = inputMoney;
	}

	public Products getProducts() {
		return products;
	}

	public int getInputMoney() {
		return inputMoney;
	}
}

package vendingmachine.controller;

import static vendingmachine.view.VendingMachineInputView.*;
import static vendingmachine.view.VendingMachineOutputView.*;

import vendingmachine.domain.Products;
import vendingmachine.domain.RemainCoin;
import vendingmachine.dto.AddProductsDto;
import vendingmachine.dto.InitCoinDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	private RemainCoin coins = new RemainCoin();
	private Products products = new Products();

	public VendingMachine() {
	}

	public void initCoin() {
		printRequestHoldingAmountMessage();
		int totalAmount = readAmount();
		vendingMachineService.initCoin(coins, new InitCoinDto(totalAmount));
	}

	public void showCoinState() {
		printCoinState(coins);
	}

	public void addProducts() {
		printRequestProductInformation();
		Products newProducts = readProduct();
		products = vendingMachineService
			.addProducts(new AddProductsDto(products, newProducts))
			.getProducts();
	}
}

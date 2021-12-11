package vendingmachine.controller;

import static vendingmachine.view.VendingMachineInputView.*;
import static vendingmachine.view.VendingMachineOutputView.*;

import vendingmachine.domain.Amount;
import vendingmachine.domain.ProductName;
import vendingmachine.domain.Products;
import vendingmachine.domain.Coins;
import vendingmachine.dto.AddProductsDto;
import vendingmachine.dto.CanSellDto;
import vendingmachine.dto.InitCoinDto;
import vendingmachine.dto.RequestChangesDto;
import vendingmachine.dto.ResponseChangesDto;
import vendingmachine.dto.SellProductResultDto;
import vendingmachine.dto.ResponseMoneyState;
import vendingmachine.dto.SellProductDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	private Coins coins = new Coins();
	private Products products = new Products();
	private int inputMoney = 0;

	public VendingMachine() {
	}

	public void initCoin() {
		printRequestHoldingAmountMessage();
		Amount totalAmount = readAmount();
		vendingMachineService.initCoin(new InitCoinDto(coins, totalAmount));
		printLineSeparator();
	}

	public void showCoinState() {
		printCoinState(coins);
		printLineSeparator();
	}

	public void addProducts() {
		printRequestProductInformation();
		Products newProducts = readProduct();
		products = vendingMachineService
			.addProducts(new AddProductsDto(products, newProducts))
			.getProducts();
		printLineSeparator();
	}

	public void sellProducts() {
		printRequestMoneyMessage();
		inputMoney += readAmount().get();
		printLineSeparator();

		while (vendingMachineService.canSell(new CanSellDto(products, inputMoney))) {
			printNowMoneyState(new ResponseMoneyState(inputMoney));
			printRequestBuyProductNameMessage();
			ProductName productName = readProductName();
			SellProductResultDto sellProductResultDto = vendingMachineService.sellProduct(
				new SellProductDto(products, productName, inputMoney));
			inputMoney = sellProductResultDto.getInputMoney();
			printLineSeparator();
		}
		printNowMoneyState(new ResponseMoneyState(inputMoney));
		ResponseChangesDto responseChangesDto = vendingMachineService.calculateChange(
			new RequestChangesDto(coins, inputMoney));
		inputMoney = responseChangesDto.getMoney();
		printChanges(responseChangesDto.getChange());
	}
}

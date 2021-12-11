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
		while (true) {
			try {
				printRequestHoldingAmountMessage();
				Amount totalAmount = readAmount();
				vendingMachineService.initCoin(new InitCoinDto(coins, totalAmount));
				printLineSeparator();
				return;
			} catch (IllegalArgumentException e) {
				printExceptionMessage(e);
			}
		}
	}

	public void showCoinState() {
		printCoinState(coins);
		printLineSeparator();
	}

	public void registerProducts() {
		while (true) {
			try {
				printRequestProductInformation();
				Products newProducts = readProduct();
				products = vendingMachineService
					.registerProducts(new AddProductsDto(products, newProducts))
					.getProducts();
				printLineSeparator();
				return;
			} catch (IllegalArgumentException e) {
				printExceptionMessage(e);
			}
		}
	}

	public void startSellPhase() {
		requestMoney();
		while (vendingMachineService.canSell(new CanSellDto(products, inputMoney))) {
			sellProduct();
		}
		responseChanges();
	}

	private void requestMoney() {
		printRequestMoneyMessage();
		inputMoney += readAmount().get();
		printLineSeparator();
	}

	private void sellProduct() {
		printNowMoneyState(new ResponseMoneyState(inputMoney));
		printRequestBuyProductNameMessage();
		ProductName productName = readProductName();
		SellProductResultDto sellProductResultDto = vendingMachineService.sellProduct(
			new SellProductDto(products, productName, inputMoney));
		inputMoney = sellProductResultDto.getInputMoney();
		printLineSeparator();
	}

	private void responseChanges() {
		printNowMoneyState(new ResponseMoneyState(inputMoney));
		ResponseChangesDto responseChangesDto = vendingMachineService.calculateChange(
			new RequestChangesDto(coins, inputMoney));
		inputMoney = responseChangesDto.getMoney();
		printChanges(responseChangesDto.getChange());
	}
}

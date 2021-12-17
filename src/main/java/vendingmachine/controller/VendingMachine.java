package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductDto;
import vendingmachine.dto.RequestSellProductDto;
import vendingmachine.dto.ResponseCoinQuantityDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	private VendingMachineService vendingMachineService;

	public VendingMachine() {
		vendingMachineService = new VendingMachineService();
	}

	public void setupCoin() {
		RequestHoldingMoneyDto requestHoldingMoneyDto = inputHoldingMoney();
		vendingMachineService.setupCoin(requestHoldingMoneyDto);
	}

	public void showCoinQuantity() {
		ResponseCoinQuantityDto responseCoinQuantityDto = vendingMachineService.getCoinQuantity();
		outputCoinQuantity(responseCoinQuantityDto);
	}

	public void registerProduct() {
		RequestRegisterProductDto requestRegisterProductDto = inputRegisterProduct();
		vendingMachineService.registerProduct(requestRegisterProductDto);
	}

	public void insertMoney() {
		RequestInsertMoneyDto requestInsertMoneyDto = inputInsertMoney();
		vendingMachineService.insertMoney(requestInsertMoneyDto);
	}

	public void sellProduct() {
		RequestSellProductDto requestSellProductDto = inputSellProduct(vendingMachineService.getPayMoney());
	}
}

package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestRegisterProductDto;
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
	}
}

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
		while (true) {
			try {
				RequestHoldingMoneyDto requestHoldingMoneyDto = inputHoldingMoney();
				vendingMachineService.setupCoin(requestHoldingMoneyDto);
				return;
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	public void showCoinQuantity() {
		ResponseCoinQuantityDto responseCoinQuantityDto = vendingMachineService.getCoinQuantity();
		outputCoinQuantity(responseCoinQuantityDto);
	}

	public void registerProduct() {
		while (true) {
			try {
				RequestRegisterProductDto requestRegisterProductDto = inputRegisterProduct();
				vendingMachineService.registerProduct(requestRegisterProductDto);
				return;
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	public void insertMoney() {
		while (true) {
			try {
				RequestInsertMoneyDto requestInsertMoneyDto = inputInsertMoney();
				vendingMachineService.insertMoney(requestInsertMoneyDto);
				return;
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	public void sellProduct() {
		while (vendingMachineService.hasSellProduct()) {
			sellProductStep();
		}
	}

	private void sellProductStep() {
		while (true) {
			try {
				RequestSellProductDto requestSellProductDto = inputSellProduct(vendingMachineService.getPayMoney());
				vendingMachineService.sellProduct(requestSellProductDto);
				return;
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	public void returnChange() {
		printPayMoney(vendingMachineService.getPayMoney());
		outputReturnChange(vendingMachineService.returnChange());
	}
}

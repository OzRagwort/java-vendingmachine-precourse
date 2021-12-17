package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;
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
}

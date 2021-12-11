package vendingmachine.controller;

import static vendingmachine.view.VendingMachineInputView.*;
import static vendingmachine.view.VendingMachineOutputView.*;

import vendingmachine.domain.RemainCoin;
import vendingmachine.dto.InitCoinDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	private RemainCoin coins = new RemainCoin();

	public VendingMachine() {
	}

	public void initCoin() {
		printRequestHoldingAmountMessage();
		int totalAmount = readAmount();
		vendingMachineService.initCoin(coins, new InitCoinDto(totalAmount));
	}
}

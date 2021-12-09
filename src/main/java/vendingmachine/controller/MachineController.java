package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.domain.Amount;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class MachineController {
	private static final int INIT_HOLDING_AMOUNT = 0;

	private VendingMachine vendingMachine;

	public MachineController() {
		int initHoldingAmount = new Amount(INIT_HOLDING_AMOUNT).get();
		vendingMachine = new VendingMachine(initHoldingAmount);
	}

	public void setupHoldingAmount() {
		printRequestHoldingAmount();
		int amount = readAmount();
		vendingMachine = new VendingMachine(amount);
	}

	public void printVendingMachineCoinState() {
		if (vendingMachine != null) {
			OutputView.printVendingMachineCoinState(vendingMachine);
		}

	}

	public void requestProducts() {
		printRequestProducts();
		String inputProductString = readProductsMessage();
		vendingMachine.addProducts(inputProductString);
	}

	public void requestMoney() {
		printRequestMoney();
		int money = readAmount();
		vendingMachine.payMoney(money);
	}
}

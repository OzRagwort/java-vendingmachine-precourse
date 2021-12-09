package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.domain.Amount;
import vendingmachine.domain.VendingMachine;

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
}

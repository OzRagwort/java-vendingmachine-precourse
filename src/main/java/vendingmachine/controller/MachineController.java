package vendingmachine.controller;

import static vendingmachine.View.InputView.*;
import static vendingmachine.View.OutputView.*;

import vendingmachine.domain.VendingMachine;

public class MachineController {
	private VendingMachine vendingMachine;

	public MachineController() {
	}

	private void setupHoldingAmount() {
		printRequestAmountMessage();
		int amount = readAmount();
		System.out.println();
		vendingMachine = new VendingMachine(amount);
	}
}

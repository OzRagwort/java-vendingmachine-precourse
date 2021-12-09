package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.domain.VendingMachine;

public class MachineController {
	private VendingMachine vendingMachine;

	public MachineController() {
	}

	public void setupHoldingAmount() {
		printRequestHoldingAmount();
		int amount = readAmount();
		vendingMachine = new VendingMachine(amount);
	}
}

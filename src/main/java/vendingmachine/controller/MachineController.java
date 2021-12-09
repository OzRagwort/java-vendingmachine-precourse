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
		while (true) {
			try {
				int amount = readAmount();
				vendingMachine = new VendingMachine(amount);
				System.out.println();
				break;
			} catch (IllegalArgumentException e) {
				printException(e);
			}
		}
	}

	public void printVendingMachineCoinState() {
		if (vendingMachine != null) {
			OutputView.printVendingMachineCoinState(vendingMachine);
		}
	}

	public void requestProducts() {
		printRequestProducts();
		while (true) {
			try {
				String inputProductString = readProductsMessage();
				vendingMachine.addProducts(inputProductString);
				System.out.println();
				break;
			} catch (IllegalArgumentException e) {
				printException(e);
			}
		}
	}

	public void requestMoney() {
		printRequestMoney();
		while (true) {
			try {
				int money = readAmount();
				vendingMachine.payMoney(money);
				System.out.println();
				break;
			} catch (IllegalArgumentException e) {
				printException(e);
			}
		}
	}

	public void buyProduct() {
		printInMoney(vendingMachine);
		printRequestProductNameToBuy();
		while (true) {
			try {
				String productName = readProductName();
				vendingMachine.sell(productName);
				System.out.println();
				break;
			} catch (IllegalArgumentException e) {
				printException(e);
			}
		}
	}

	public void printChanges() {
		printInMoney(vendingMachine);
		OutputView.printChanges(vendingMachine.returnChanges());
	}

	public boolean canSell() {
		return vendingMachine.canSell();
	}
}

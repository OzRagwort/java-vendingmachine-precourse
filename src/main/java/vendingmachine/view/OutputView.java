package vendingmachine.view;

import static vendingmachine.enums.PrintMessage.*;

import vendingmachine.domain.VendingMachine;

public class OutputView {
	public static void printRequestHoldingAmount() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE.get());
	}

	public static void printVendingMachineCoinState(VendingMachine vendingMachine) {
		System.out.println(RESPONSE_COIN_STATE_MESSAGE.get());
		System.out.println(vendingMachine.toString());
	}

	public static void printRequestProducts() {
		System.out.println(REQUEST_ADD_PRODUCT_MESSAGE.get());
	}

	public static void printRequestMoney() {
		System.out.println(REQUEST_MONEY_MESSAGE.get());
	}

	public static void printInMoney(VendingMachine vendingMachine) {
		String printText = String.format(
			RESPONSE_IN_MONEY_FORM.get(),
			vendingMachine.getInMoney()
		);
		System.out.println(printText);
	}

	public static void printRequestProductNameToBuy() {
		System.out.println(REQUEST_PRODUCT_NAME_TO_BUY.get());
	}
}

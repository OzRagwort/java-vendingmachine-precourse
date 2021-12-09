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
}

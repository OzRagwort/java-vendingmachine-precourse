package vendingmachine.View;

import static vendingmachine.enums.PrintMessage.*;

import vendingmachine.domain.CoinMap;

public class OutputView {
	public static void printRequestAmountMessage() {
		System.out.println(REQUEST_AMOUNT_MESSAGE.get());
	}

	public static void printVendingMachineState(CoinMap coinMap) {
		System.out.println(RESPONSE_VENDING_MACHINE_STATE_MESSAGE.get());
		System.out.println(coinMap.toString());
	}
}

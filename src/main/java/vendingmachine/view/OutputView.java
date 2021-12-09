package vendingmachine.view;

import static vendingmachine.enums.PrintMessage.*;

public class OutputView {
	public static void printRequestHoldingAmount() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE.get());
	}
}

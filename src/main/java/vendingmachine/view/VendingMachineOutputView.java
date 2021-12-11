package vendingmachine.view;

import static vendingmachine.enums.OutputMessage.*;

public class VendingMachineOutputView {
	public static void printRequestHoldingAmountMessage() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE.get());
	}
}

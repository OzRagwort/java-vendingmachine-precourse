package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import vendingmachine.domain.Amount;

public class InputView {
	public static int readAmount() {
		return new Amount(readLine()).get();
	}

	public static String readProductsMessage() {
		return readLine();
	}
}

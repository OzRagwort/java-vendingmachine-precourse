package vendingmachine.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

import vendingmachine.domain.Amount;

public class InputView {
	public static int readAmount() {
		return (new Amount(readLine()).get());
	}
}

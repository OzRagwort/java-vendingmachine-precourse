package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class VendingMachineInputView {
	public static int readAmount() {
		return Integer.parseInt(readLine());
	}
}

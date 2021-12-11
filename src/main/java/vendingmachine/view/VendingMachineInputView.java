package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.Products;

public class VendingMachineInputView {
	public static int readAmount() {
		return Integer.parseInt(readLine());
	}

	public static Products readProduct() {
		Products newProducts = new Products();
		newProducts.addByString(readLine());
		return newProducts;
	}
}

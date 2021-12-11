package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.Amount;
import vendingmachine.domain.ProductName;
import vendingmachine.domain.Products;

public class VendingMachineInputView {
	public static Amount readAmount() {
		return new Amount(readLine());
	}

	public static Products readProduct() {
		Products newProducts = new Products();
		newProducts.addByString(readLine());
		return newProducts;
	}

	public static ProductName readProductName() {
		return new ProductName(readLine());
	}
}

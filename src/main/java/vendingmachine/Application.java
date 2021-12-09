package vendingmachine;

import vendingmachine.controller.MachineController;

public class Application {
	public static void main(String[] args) {
		MachineController controller = new MachineController();
		programStart(controller);
	}

	private static void programStart(final MachineController controller) {
		controller.setupHoldingAmount();
		controller.printVendingMachineCoinState();
		controller.requestProducts();
		controller.requestMoney();
		while (controller.canSell()) {
			controller.buyProduct();
		}
		controller.printChanges();
	}
}

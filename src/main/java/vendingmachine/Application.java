package vendingmachine;

import vendingmachine.controller.VendingMachine;

public class Application {
	public static void main(String[] args) {
		start();
	}

	public static void start() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.initCoin();
		vendingMachine.showCoinState();
		vendingMachine.registerProducts();
		vendingMachine.startSellPhase();
	}
}

package vendingmachine.domain;

public class VendingMachine {
	private int holdingAmount;
	private CoinMap coinMap;

	public VendingMachine(final int amount) {
		this.holdingAmount = amount;
		this.coinMap = new CoinMap(amount);
	}
}

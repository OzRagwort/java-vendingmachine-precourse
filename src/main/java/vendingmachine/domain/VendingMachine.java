package vendingmachine.domain;

public class VendingMachine {
	private int restAmount;
	private CoinMap coinMap;

	public VendingMachine(final int restAmount) {
		this.restAmount = restAmount;
		coinMap = new CoinMap(restAmount);
	}
}

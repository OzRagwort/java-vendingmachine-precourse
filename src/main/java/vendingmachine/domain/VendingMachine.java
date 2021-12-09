package vendingmachine.domain;

import vendingmachine.enums.Coin;

public class VendingMachine {
	private static final String TO_STRING_FORM = "%d원 - %d개";

	private CoinMap coinMap;
	private Products products;

	public VendingMachine(final int amount) {
		this.coinMap = new CoinMap(amount);
		this.products = new Products();
	}

	public void addProducts(String inputProductString) {
		products.add(inputProductString);
	}

	public String toString() {
		StringBuilder log = new StringBuilder();
		for (Coin coin : Coin.values()) {
			int key = coin.get();
			int count = coinMap.getCount(key);
			log.append(String.format(TO_STRING_FORM, key, count))
				.append(System.lineSeparator());
		}
		return log.toString();
	}
}

package vendingmachine.domain;

import static vendingmachine.enums.PrintMessage.*;

import java.util.HashMap;

import vendingmachine.enums.Coin;

public class VendingMachine {
	private CoinMap coinMap;
	private Products products;
	private int inMoney;

	public VendingMachine(final int amount) {
		this.coinMap = new CoinMap(amount);
		this.products = new Products();
	}

	public void addProducts(String inputProductString) {
		products.add(inputProductString);
	}

	public void payMoney(int money) {
		inMoney += money;
	}

	public void sell(String productName) {
		inMoney = products.sell(productName, inMoney);
	}

	public HashMap<Integer, Integer> returnChanges() {
		HashMap<Integer, Integer> changes = new HashMap<>();
		for (Coin coin : Coin.values()) {
			int change = coinMap.getChanges(inMoney, coin.get());
			if (change != 0) {
				changes.put(coin.get(), change);
				inMoney -= coin.get() * change;
			}
		}
		return changes;
	}

	public boolean canSell() {
		return products.canSell(inMoney);
	}

	public int getInMoney() {
		return inMoney;
	}

	public String toString() {
		StringBuilder log = new StringBuilder();
		for (Coin coin : Coin.values()) {
			int key = coin.get();
			int count = coinMap.getCount(key);
			log.append(String.format(COIN_COUNT_FORM.get(), key, count))
				.append(System.lineSeparator());
		}
		return log.toString();
	}
}

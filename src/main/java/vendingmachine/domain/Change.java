package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.enums.Coin;

public class Change {
	private final Map<Coin, Quantity> change = new HashMap<>();

	public Change() {
	}

	public void add(Coin coin, Quantity quantity) {
		change.put(coin, quantity);
	}

	public boolean containsCoin(Coin coin) {
		return change.containsKey(coin);
	}

	public Quantity getQuantity(Coin coin) {
		return change.get(coin);
	}
}

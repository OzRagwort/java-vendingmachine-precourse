package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.enums.Coin;

public class CoinMap {
	private static final String RESPONSE_VENDING_MACHINE_STATE_FORM = "%d원 - %d개";

	HashMap<Integer, Integer> coinMap = new HashMap<>();

	public CoinMap(final int restAmount) {
		List<Integer> coinTypes = Arrays
			.stream(Coin.values())
			.map(Coin::get)
			.collect(Collectors.toList());
		for (int amount : coinTypes) {
			coinMap.put(amount, 0);
		}
		setRandomCoinMap(coinTypes, restAmount);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Coin coin : Coin.values()) {
			int key = coin.get();
			stringBuilder.append(String.format(RESPONSE_VENDING_MACHINE_STATE_FORM, key, coinMap.get(key)));
			stringBuilder.append(System.lineSeparator());
		}
		return stringBuilder.toString();
	}

	private void setRandomCoinMap(final List<Integer> coinTypes, final int restAmount) {
		int amount = 0;
		while (amount < restAmount) {
			int random = pickNumberInList(coinTypes);
			if (amount + random <= restAmount) {
				coinMap.put(random, coinMap.get(random) + 1);
				amount += random;
			}
		}
	}
}

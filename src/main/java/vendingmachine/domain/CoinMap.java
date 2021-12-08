package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.Coin;

public class CoinMap {
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

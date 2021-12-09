package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.enums.Coin;

public class CoinMap {
	private HashMap<Integer, Integer> coinMap = new HashMap<>();

	public CoinMap(final int amount) {
		List<Integer> coins = Arrays.stream(Coin.values())
			.map(Coin::get)
			.collect(Collectors.toList());
		setMapKeys(coins);
		generateCoins(coins, amount);
	}

	public int getCount(final int key) {
		return coinMap.get(key);
	}

	public int getChanges(final int inMoney, final int amount) {
		int coinCount = coinMap.get(amount);
		int changesCount = Math.min(inMoney / amount, coinCount);
		coinMap.put(amount, coinMap.get(amount) - changesCount);
		return changesCount;
	}

	private void setMapKeys(final List<Integer> coins) {
		for (int coin : coins) {
			coinMap.put(coin, 0);
		}
	}

	private void generateCoins(List<Integer> coins, final int amount) {
		int remainAmount = amount;
		while (remainAmount > 0) {
			int pick = pickNumberInList(coins);
			if (pick <= remainAmount) {
				remainAmount -= pick;
				coinMap.put(pick, coinMap.get(pick) + 1);
			}
		}
	}
}

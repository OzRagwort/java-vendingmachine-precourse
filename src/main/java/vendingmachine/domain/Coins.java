package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.enums.Coin;

public class Coins {
	private static final int INIT_COUNT = 0;

	HashMap<Integer, Integer> coins = new HashMap<>();

	public Coins() {
	}

	public void initCoins(int totalAmount) {
		List<Integer> coinList = Arrays.stream(Coin.values())
			.map(Coin::get)
			.collect(Collectors.toList());
		coinList.forEach(integer -> coins.put(integer, INIT_COUNT));
		while (totalAmount > 0) {
			int coin = pickNumberInList(coinList);
			if (coin <= totalAmount) {
				totalAmount -= coin;
				coins.put(coin, coins.get(coin) + 1);
			}
		}
	}

	public int getCount(int amount) {
		return coins.get(amount);
	}
}

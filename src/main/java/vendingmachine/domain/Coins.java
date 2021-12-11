package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.ResponseChangesDto;
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

	public void addCount(int amount, int count) {
		coins.put(amount, coins.get(amount) + count);
	}

	public void subCount(int amount, int count) {
		coins.put(amount, coins.get(amount) - count);
	}

	public ResponseChangesDto calculateChange(int money) {
		Coins change = new Coins();
		change.initCoins(INIT_COUNT);
		for (Coin coin : Coin.values()) {
			int amount = coin.get();
			int count = Math.min(coins.get(amount), money / amount);
			this.subCount(amount, count);
			change.addCount(amount, count);
			money -= amount * count;
		}
		return new ResponseChangesDto(change, money);
	}

	public boolean hasAmount(int amount) {
		return coins.get(amount) > 0;
	}
}

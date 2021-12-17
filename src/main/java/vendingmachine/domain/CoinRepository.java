package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.enums.Coin;

public class CoinRepository {
	private static final String INIT_COIN_QUANTITY = "0";
	private static final Quantity ONE_QUANTITY = new Quantity("1");

	private final Map<Coin, Quantity> coins = new HashMap<>();

	public CoinRepository() {
		clear();
	}

	public void addMoney(Money money) {
		List<Integer> amountList = Coin.amountList();
		while (money.isRemain()) {
			int randomAmount = pickNumberInList(amountList);
			if (money.moreThan(randomAmount)) {
				Coin coin = Coin.findByAmount(randomAmount);
				coins.get(coin).add(ONE_QUANTITY);
				money.sub(coin.getTotalAmount(ONE_QUANTITY));
			}
		}
	}

	public Map<Coin, Quantity> getCoinQuantity() {
		return Collections.unmodifiableMap(coins);
	}

	public void clear() {
		for (Coin coin : Coin.values()) {
			coins.put(coin, new Quantity(INIT_COIN_QUANTITY));
		}
	}
}

package vendingmachine.enums;

import static vendingmachine.enums.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Quantity;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> amountList() {
		return Arrays.stream(Coin.values())
			.map(coin -> coin.amount)
			.collect(Collectors.toList());
	}

	public static Coin findByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(FAIL_FIND_BY_AMOUNT_ERROR.get()));
	}

	public int getAmount() {
		return amount;
	}

	public int getTotalAmount(Quantity quotient) {
		return quotient.mul(amount);
	}
}

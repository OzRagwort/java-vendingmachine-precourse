package vendingmachine.domain;

import static vendingmachine.enums.AmountCondition.*;
import static vendingmachine.enums.Coin.*;
import static vendingmachine.enums.ErrorMessage.*;

public class Amount {
	private final int amount;

	public Amount(final String amount) {
		validateNumberFormat(amount);
		int integerAmount = Integer.parseInt(amount);
		validateRange(integerAmount);
		validateDivisibleByMinimumCoin(integerAmount);
		this.amount = integerAmount;
	}

	public int get() {
		return amount;
	}

	private void validateNumberFormat(final String amount) {
		try {
			Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE.get());
		}
	}

	private void validateRange(final int amount) {
		if (amount < MIN_AMOUNT.get()) {
			throw new IllegalArgumentException(AMOUNT_OUT_OF_RANGE_ERROR_MESSAGE.get());
		}
	}

	private void validateDivisibleByMinimumCoin(final int amount) {
		int minimumAmount = COIN_10.get();
		if (amount % minimumAmount != 0) {
			throw new IllegalArgumentException(DIVISIBLE_BY_MINIMUM_COIN_ERROR_MESSAGE.get());
		}
	}
}

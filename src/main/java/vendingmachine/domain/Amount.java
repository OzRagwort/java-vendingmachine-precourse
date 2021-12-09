package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import vendingmachine.enums.Coin;

public class Amount {
	private int amount;

	public Amount(final String amount) {
		validateNumberFormat(amount);
		int integerAmount = Integer.parseInt(amount);
		validateRange(integerAmount);
		validateDivisible(integerAmount);
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
		if (amount < 0) {
			throw new IllegalArgumentException(AMOUNT_NEGATIVE_NUMBER_ERROR_MESSAGE.get());
		}
	}

	private void validateDivisible(final int amount) {
		if (amount % Coin.COIN_10.get() == 0) {
			throw new IllegalArgumentException(AMOUNT_NOT_DIVISIBLE_BY_10_ERROR_MESSAGE.get());
		}
	}
}

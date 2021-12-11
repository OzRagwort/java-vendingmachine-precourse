package vendingmachine.domain;

import vendingmachine.enums.Coin;
import vendingmachine.enums.ErrorMessage;

public class Amount {
	private static final String AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE;
	private static final String AMOUNT_NEGATIVE_NUMBER_MESSAGE;
	private static final String AMOUNT_DIVISIBLE_BY_10_ERROR_MESSAGE;

	static {
		AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE = ErrorMessage.AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE.get();
		AMOUNT_NEGATIVE_NUMBER_MESSAGE = ErrorMessage.AMOUNT_NEGATIVE_NUMBER_MESSAGE.get();
		AMOUNT_DIVISIBLE_BY_10_ERROR_MESSAGE = ErrorMessage.AMOUNT_DIVISIBLE_BY_10_ERROR_MESSAGE.get();
	}

	private final int amount;

	public Amount(String value) {
		validateNumberFormat(value);
		int amount = Integer.parseInt(value);
		validateRange(amount);
		validateDivisibleBy10(amount);
		this.amount = amount;
	}

	public int get() {
		return amount;
	}

	private void validateNumberFormat(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}

	private void validateRange(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(AMOUNT_NEGATIVE_NUMBER_MESSAGE);
		}
	}

	private void validateDivisibleBy10(int amount) {
		if (amount % Coin.COIN_10.get() != 0) {
			throw new IllegalArgumentException(AMOUNT_DIVISIBLE_BY_10_ERROR_MESSAGE);
		}
	}
}

package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import vendingmachine.enums.Coin;

public class Money {
	private int money;

	public Money(String input) {
		validateNumberFormat(input);
		int integerInput = Integer.parseInt(input);
		validateNegative(integerInput);
		validateDividedByTen(integerInput);
		this.money = integerInput;
	}

	public int get() {
		return money;
	}

	private void validateNumberFormat(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MONEY_NUMBER_FORMAT_ERROR.get());
		}
	}

	private void validateNegative(int integerInput) {
		if (integerInput < 0) {
			throw new IllegalArgumentException(MONEY_LOWER_THEN_ZERO_ERROR.get());
		}
	}

	private void validateDividedByTen(int integerInput) {
		if (integerInput % Coin.COIN_10.getAmount() != 0) {
			throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_TEN_ERROR.get());
		}
	}
}

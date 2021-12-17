package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

import vendingmachine.enums.Coin;

public class Money {
	private static final int EMPTY_MONEY = 0;

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

	public void add(Money money) {
		this.money += money.money;
	}

	public void sub(int totalAmount) {
		this.money -= totalAmount;
	}

	public boolean moreThan(int amount) {
		return money >= amount;
	}

	public boolean underThan(int amount) {
		return money < amount;
	}

	public boolean isRemain() {
		return money > EMPTY_MONEY;
	}

	public boolean canAdd(Money money) {
		long longMoney = (long)this.money + (long)money.money;
		if (longMoney <= Integer.MAX_VALUE) {
			return true;
		}
		return false;
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

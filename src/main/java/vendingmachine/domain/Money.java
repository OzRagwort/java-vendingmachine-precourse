package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Money {
	private int money;

	public Money(String input) {
		validateNumberFormat(input);
		this.money = Integer.parseInt(input);
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
}

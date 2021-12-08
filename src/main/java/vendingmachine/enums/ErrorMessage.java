package vendingmachine.enums;

import static vendingmachine.enums.Coin.COIN_10;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR]"),
	AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE + "금액은 정수로 입력해야합니다."),
	AMOUNT_OUT_OF_RANGE_ERROR_MESSAGE(ERROR_MESSAGE + "금액은 0 이상으로 입력해야합니다."),
	DIVISIBLE_BY_MINIMUM_COIN_ERROR_MESSAGE(ERROR_MESSAGE + "금액은 " + COIN_10 + "으로 나누어 떨어져야 합니다.");

	private final String message;

	ErrorMessage(final String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

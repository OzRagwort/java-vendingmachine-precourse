package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "금액은 숫자로 입력해주세요."),
	AMOUNT_NEGATIVE_NUMBER_ERROR_MESSAGE(ERROR_MESSAGE.get() + "0 이상의 금액을 입력해주세요."),
	AMOUNT_NOT_DIVISIBLE_BY_10_ERROR_MESSAGE(ERROR_MESSAGE.get() + "금액은 "
		+ Coin.COIN_10.get()
		+ "으로 나누어 떨어져야 합니다.");

	private final String message;

	ErrorMessage(final String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

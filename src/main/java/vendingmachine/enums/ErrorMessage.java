package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "금액은 0 ~ 2147483647의 숫자로 입력해주세요."),
	AMOUNT_NEGATIVE_NUMBER_MESSAGE(ERROR_MESSAGE.get() + "금액은 0 이상 입력해 주세요."),
	AMOUNT_DIVISIBLE_BY_10_ERROR_MESSAGE(
		ERROR_MESSAGE.get() + "금액은 " + Coin.COIN_10.get() + "으로 나누어 떨어져야 합니다."),
	NO_PRODUCT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "상품이 없습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

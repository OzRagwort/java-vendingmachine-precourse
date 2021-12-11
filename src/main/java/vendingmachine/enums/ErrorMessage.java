package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "금액은 0 ~ 2147483647의 숫자로 입력해주세요."),
	AMOUNT_NEGATIVE_NUMBER_MESSAGE(ERROR_MESSAGE.get() + "금액은 0 이상 입력해 주세요."),
	AMOUNT_DIVISIBLE_BY_10_ERROR_MESSAGE(
		ERROR_MESSAGE.get() + "금액은 " + Coin.COIN_10.get() + "으로 나누어 떨어져야 합니다."),
	PRICE_LOWER_THEN_MINIMUM_PRICE_ERROR_MESSAGE(ERROR_MESSAGE.get() + "가격은 최소 100이상이어야 합니다."),
	QUANTITY_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "수량은 0 ~ 2147483647의 숫자로 입력해주세요."),
	QUANTITY_NEGATIVE_NUMBER_MESSAGE(ERROR_MESSAGE.get() + "수량은 0 이상 입력해 주세요."),
	PRODUCT_INPUT_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "추가할 상품은 [상품명,가격,수량] 형식으로 입력해주세요."),
	NO_PRODUCT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "상품이 없습니다."),
	REGISTERED_PRODUCT_NAME_ERROR_MESSAGE(ERROR_MESSAGE.get() + "이미 등록된 상품명이 있습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

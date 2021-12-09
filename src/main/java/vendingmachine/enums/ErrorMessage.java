package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "금액은 숫자로 입력해주세요."),
	AMOUNT_NEGATIVE_NUMBER_ERROR_MESSAGE(ERROR_MESSAGE.get() + "0 이상의 금액을 입력해주세요."),
	AMOUNT_NOT_DIVISIBLE_BY_10_ERROR_MESSAGE(ERROR_MESSAGE.get() + "금액은 "
		+ Coin.COIN_10.get()
		+ "으로 나누어 떨어져야 합니다."),
	PRODUCT_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "상품은 \"[상품명,가격,수량]\"으로 입력해주세요."),
	PRODUCT_REGISTERED_ERROR_MESSAGE(ERROR_MESSAGE.get() + "이미 등록된 상품이 추가되어있습니다."),
	QUANTITY_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE.get() + "수량은 숫자로 입력해주세요."),
	QUANTITY_NEGATIVE_NUMBER_ERROR_MESSAGE(ERROR_MESSAGE.get() + "0 이상의 수량을 입력해주세요."),
	LOWER_THAN_MINIMUM_PRICE_ERROR_MESSAGE(ERROR_MESSAGE.get() + "최소 가격 이상의 가격을 입력해주세요."),
	NO_PRODUCT_ERROR_MESSAGE_FORM(ERROR_MESSAGE.get() + "자판기에 %s가 없습니다."),
	NO_QUANTITY_ERROR_MESSAGE_FORM(ERROR_MESSAGE.get() + "자판기에 남은 %s가 없습니다."),
	LACK_MONEY_ERROR_MESSAGE(ERROR_MESSAGE.get() + "돈이 모자랍니다.");

	private final String message;

	ErrorMessage(final String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

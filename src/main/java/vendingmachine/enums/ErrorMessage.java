package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	MONEY_NUMBER_FORMAT_ERROR("금액은 숫자로 입력해야 합니다."),
	MONEY_LOWER_THEN_ZERO_ERROR("금액은 0 이상 입력해야 합니다."),
	MONEY_NOT_DIVIDED_BY_TEN_ERROR("금액은 10으로 나누어 떨어져야 합니다."),
	FAIL_FIND_BY_AMOUNT_ERROR("없는 동전 종류입니다."),
	PRODUCT_PATTERN_ERROR("상품의 형식을 잘못입력하셨습니다."),
	ALREADY_REGISTERED_PRODUCT_ERROR("이미 등록된 상품을 등록하였습니다."),
	NAME_LENGTH_SO_SHORT_ERROR("상품명은 1글자 이상 써주세요"),
	PRICE_UNDER_THAN_MINIMUM_PRICE_ERROR("가격은 100원 이상이어야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		if (message.equals(ERROR_MESSAGE.message)) {
			return ERROR_MESSAGE.message;
		}
		return ERROR_MESSAGE.message + message;
	}
}

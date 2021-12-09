package vendingmachine.enums;

import static vendingmachine.enums.Coin.COIN_10;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR]"),
	AMOUNT_NUMBER_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE + "금액은 정수로 입력해야합니다."),
	AMOUNT_OUT_OF_RANGE_ERROR_MESSAGE(ERROR_MESSAGE + "금액은 0 이상으로 입력해야합니다."),
	DIVISIBLE_BY_MINIMUM_COIN_ERROR_MESSAGE(ERROR_MESSAGE + "금액은 " + COIN_10 + "으로 나누어 떨어져야 합니다."),
	PRODUCT_FORMAT_ERROR_MESSAGE(ERROR_MESSAGE + "제품의 형식은 \"[상품명,가격,수량]\"으로 입력해야 합니다."),
	LOWER_THAN_MINIMUM_PRICE_ERROR_MESSAGE(ERROR_MESSAGE + "제품의 가격은 100원 이상이어야 합니다."),
	NOT_DIVISIBLE_BY_COIN_10_ERROR_MESSAGE(ERROR_MESSAGE + "제품의 가격은 " + COIN_10 + "으로 나누어 떨어져야 합니다."),
	LOWER_THAN_ZERO_QUANTITY_ERROR_MESSAGE(ERROR_MESSAGE + "제품의 수량은 0개 이상이어야 합니다.");

	private final String message;

	ErrorMessage(final String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

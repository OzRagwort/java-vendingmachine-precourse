package vendingmachine.enums;

public enum OutputMessage {
	REQUEST_HOLDING_AMOUNT_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
	RESPONSE_COIN_STATE_MESSAGE("자판기가 보유한 동전"),
	RESPONSE_COIN_STATE_FORM("%d원 - %d개"),
	REQUEST_PRODUCT_INFORMATION_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
	REQUEST_MONEY_MESSAGE("투입 금액을 입력해 주세요."),
	REQUEST_BUY_PRODUCT_NAME_MESSAGE("구매할 상품명을 입력해 주세요."),
	RESPONSE_NOW_MONEY_FORM("투입 금액: %d원");

	private final String message;

	OutputMessage(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

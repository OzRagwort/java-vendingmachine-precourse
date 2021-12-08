package vendingmachine.enums;

public enum PrintMessage {
	REQUEST_AMOUNT_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요.");

	private final String message;

	PrintMessage(final String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}

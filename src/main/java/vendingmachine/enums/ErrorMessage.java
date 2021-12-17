package vendingmachine.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	MONEY_NUMBER_FORMAT_ERROR("금액은 숫자로 입력해야 합니다.");

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

package vendingmachine.enums;

public enum AmountCondition {
	MIN_AMOUNT(0);

	private final int amount;

	AmountCondition(int amount) {
		this.amount = amount;
	}

	public int get() {
		return amount;
	}
}

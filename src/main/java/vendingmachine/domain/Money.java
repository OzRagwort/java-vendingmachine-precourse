package vendingmachine.domain;

public class Money {
	private int money;

	public Money(String input) {
		this.money = Integer.parseInt(input);
	}

	public int get() {
		return money;
	}
}

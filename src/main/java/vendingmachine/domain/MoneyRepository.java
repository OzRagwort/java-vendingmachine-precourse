package vendingmachine.domain;

public class MoneyRepository {
	private static final String INIT_MONEY = "0";

	private Money money;

	public MoneyRepository() {
		clear();
	}

	public void add(Money money) {
		this.money.add(money);
	}

	public void clear() {
		money = new Money(INIT_MONEY);
	}
}

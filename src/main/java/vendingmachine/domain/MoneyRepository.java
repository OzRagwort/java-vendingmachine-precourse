package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class MoneyRepository {
	private static final String INIT_MONEY = "0";

	private Money money;

	public MoneyRepository() {
		clear();
	}

	public Money getMoney() {
		Money newMoney = new Money(INIT_MONEY);
		newMoney.add(money);
		return newMoney;
	}

	public void add(Money money) {
		if (this.money.canAdd(money)) {
			this.money.add(money);
			return;
		}
		throw new IllegalArgumentException(TOO_MUCH_INSERTED_MONEY_ERROR.get());
	}

	public void sell(Product product) {
		checkCanSell(product);
		this.money.sub(product.getPrice());
	}

	private void checkCanSell(Product product) {
		if (product.isSoldOut()) {
			throw new IllegalArgumentException(SOLD_OUT_ERROR.get());
		}
		int price = product.getPrice().get();
		if (money.underThan(price)) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR.get());
		}
	}

	public void clear() {
		money = new Money(INIT_MONEY);
	}
}

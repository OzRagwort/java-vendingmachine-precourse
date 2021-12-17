package vendingmachine.dto;

import vendingmachine.domain.Money;

public class ResponsePayMoneyDto {
	private Money money;

	public ResponsePayMoneyDto(Money money) {
		this.money = money;
	}

	public Money getMoney() {
		return money;
	}
}

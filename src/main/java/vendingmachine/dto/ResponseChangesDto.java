package vendingmachine.dto;

import vendingmachine.domain.Coins;

public class ResponseChangesDto {
	private Coins change;
	private int money;

	public ResponseChangesDto(Coins change, int money) {
		this.change = change;
		this.money = money;
	}

	public Coins getChange() {
		return change;
	}

	public int getMoney() {
		return money;
	}
}

package vendingmachine.dto;

import vendingmachine.domain.Coins;

public class RequestChangesDto {
	private Coins coins;
	private int money;

	public RequestChangesDto(Coins coins, int money) {
		this.coins = coins;
		this.money = money;
	}

	public Coins getCoins() {
		return coins;
	}

	public int getMoney() {
		return money;
	}
}

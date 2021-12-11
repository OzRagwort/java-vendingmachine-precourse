package vendingmachine.dto;

import vendingmachine.domain.Amount;
import vendingmachine.domain.Coins;

public class InitCoinDto {
	private Coins coins;
	private Amount totalAmount;

	public InitCoinDto(Coins coins, Amount totalAmount) {
		this.coins = coins;
		this.totalAmount = totalAmount;
	}

	public Coins getCoins() {
		return coins;
	}

	public Amount getTotalAmount() {
		return totalAmount;
	}
}

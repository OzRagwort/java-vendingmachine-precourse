package vendingmachine.dto;

public class ResponseMoneyState {
	private int money;

	public ResponseMoneyState(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}

package vendingmachine.dto;

public class InitCoinDto {
	private int totalAmount;

	public InitCoinDto(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}
}

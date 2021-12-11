package vendingmachine.dto;

public class SellProductResultDto {
	private int inputMoney;

	public SellProductResultDto(int inputMoney) {
		this.inputMoney = inputMoney;
	}

	public int getInputMoney() {
		return inputMoney;
	}
}

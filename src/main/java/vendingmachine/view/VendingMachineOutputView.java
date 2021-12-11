package vendingmachine.view;

import static vendingmachine.enums.OutputMessage.*;

import vendingmachine.domain.RemainCoin;
import vendingmachine.enums.Coin;

public class VendingMachineOutputView {
	public static void printRequestHoldingAmountMessage() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE.get());
	}

	public static void printCoinState(RemainCoin coins) {
		System.out.println(RESPONSE_COIN_STATE_MESSAGE.get());
		for (Coin coin : Coin.values()) {
			int amount = coin.get();
			String message = String.format(RESPONSE_COIN_STATE_FORM.get(), amount, coins.getCount(amount));
			System.out.println(message);
		}
	}
}

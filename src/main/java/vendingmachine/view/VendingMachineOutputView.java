package vendingmachine.view;

import static vendingmachine.enums.OutputMessage.*;

import vendingmachine.domain.Coins;
import vendingmachine.dto.ResponseMoneyState;
import vendingmachine.enums.Coin;

public class VendingMachineOutputView {
	public static void printLineSeparator() {
		System.out.println();
	}

	public static void printRequestHoldingAmountMessage() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE.get());
	}

	public static void printCoinState(Coins coins) {
		System.out.println(RESPONSE_COIN_STATE_MESSAGE.get());
		for (Coin coin : Coin.values()) {
			int amount = coin.get();
			String message = String.format(RESPONSE_COIN_STATE_FORM.get(), amount, coins.getCount(amount));
			System.out.println(message);
		}
	}

	public static void printRequestProductInformation() {
		System.out.println(REQUEST_PRODUCT_INFORMATION_MESSAGE.get());
	}

	public static void printRequestMoneyMessage() {
		System.out.println(REQUEST_MONEY_MESSAGE.get());
	}

	public static void printNowMoneyState(ResponseMoneyState money) {
		String message = String.format(RESPONSE_NOW_MONEY_FORM.get(), money.getMoney());
		System.out.println(message);
	}

	public static void printRequestBuyProductNameMessage() {
		System.out.println(REQUEST_BUY_PRODUCT_NAME_MESSAGE.get());
	}

	public static void printChanges(Coins coins) {
		System.out.println(RESPONSE_CHANGE_MESSAGE.get());
		for (Coin coin : Coin.values()) {
			int amount = coin.get();
			if (coins.hasAmount(amount)) {
				String message = String.format(RESPONSE_COIN_STATE_FORM.get(), amount, coins.getCount(amount));
				System.out.println(message);
			}
		}
	}
}

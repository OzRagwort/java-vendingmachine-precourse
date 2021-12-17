package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Change;
import vendingmachine.domain.Quantity;
import vendingmachine.dto.ResponseCoinQuantityDto;
import vendingmachine.dto.ResponseReturnChangeDto;
import vendingmachine.enums.Coin;

public class OutputView {
	private static final String RESPONSE_COIN_QUANTITY_MESSAGE = "자판기가 보유한 동전";
	private static final String RESPONSE_COIN_QUANTITY_FORM = "%d원 - %d개";
	private static final String RESPONSE_CHANGE_MESSAGE = "잔돈";

	public static void outputCoinQuantity(ResponseCoinQuantityDto responseCoinQuantityDto) {
		System.out.println(RESPONSE_COIN_QUANTITY_MESSAGE);
		Map<Coin, Quantity> coins = responseCoinQuantityDto.getCoins();
		for (Coin coin : Coin.values()) {
			String message = String.format(RESPONSE_COIN_QUANTITY_FORM, coin.getAmount(), coins.get(coin).get());
			System.out.println(message);
		}
		System.out.println();
	}

	public static void outputReturnChange(ResponseReturnChangeDto responseReturnChangeDto) {
		System.out.println(RESPONSE_CHANGE_MESSAGE);
		Change change = responseReturnChangeDto.getChange();
		for (Coin coin : Coin.values()) {
			if (change.containsCoin(coin)) {
				String message = String.format(RESPONSE_COIN_QUANTITY_FORM, coin.getAmount(), change.getQuantity(coin).get());
				System.out.println(message);
			}
		}
	}

	public static void outputExceptionMessage(Exception e) {
		System.out.println(e.getMessage());
	}
}

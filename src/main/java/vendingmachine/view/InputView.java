package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.Money;
import vendingmachine.domain.Name;
import vendingmachine.domain.Products;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductDto;
import vendingmachine.dto.RequestSellProductDto;
import vendingmachine.dto.ResponsePayMoneyDto;

public class InputView {
	private static final String REQUEST_HOLDING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String REQUEST_REGISTER_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String REQUEST_INSERT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	private static final String RESPONSE_PAY_MONEY_FORM = "투입 금액: %d원";
	private static final String REQUEST_SELL_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";

	public static RequestHoldingMoneyDto inputHoldingMoney() {
		System.out.println(REQUEST_HOLDING_MONEY_MESSAGE);
		Money money = new Money(readLine());
		System.out.println();
		return new RequestHoldingMoneyDto(money);
	}

	public static RequestRegisterProductDto inputRegisterProduct() {
		System.out.println(REQUEST_REGISTER_PRODUCT_MESSAGE);
		Products products = new Products(readLine());
		System.out.println();
		return new RequestRegisterProductDto(products);
	}

	public static RequestInsertMoneyDto inputInsertMoney() {
		System.out.println(REQUEST_INSERT_MONEY_MESSAGE);
		Money money = new Money(readLine());
		System.out.println();
		return new RequestInsertMoneyDto(money);
	}

	public static RequestSellProductDto inputSellProduct(ResponsePayMoneyDto responsePayMoneyDto) {
		printPayMoney(responsePayMoneyDto);
		System.out.println(REQUEST_SELL_PRODUCT_MESSAGE);
		Name name = new Name(readLine());
		System.out.println();
		return new RequestSellProductDto(name);
	}

	private static void printPayMoney(ResponsePayMoneyDto responsePayMoneyDto) {
		Money money = responsePayMoneyDto.getMoney();
		String message = String.format(RESPONSE_PAY_MONEY_FORM, money.get());
		System.out.println(message);
	}
}

package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.Money;
import vendingmachine.dto.RequestHoldingMoneyDto;

public class InputView {
	public static RequestHoldingMoneyDto inputHoldingMoney() {
		Money money = new Money(readLine());
		return new RequestHoldingMoneyDto(money);
	}
}

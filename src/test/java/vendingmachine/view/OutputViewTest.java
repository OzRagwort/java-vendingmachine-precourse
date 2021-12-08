package vendingmachine.view;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static vendingmachine.View.OutputView.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.CoinMap;

public class OutputViewTest extends NsTest {

	@DisplayName("자판기의 동전의 갯수를 출력하는 테스트")
	@Test
	void printVendingMachineStateTest() {
		assertRandomNumberInListTest(
			() -> {
				CoinMap coinMap = new CoinMap(450);
				printVendingMachineState(coinMap);
				assertThat(output()).contains(
					"500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개"
				);
			},
			100, 100, 100, 100, 50
		);
	}

	@Override
	protected void runMain() {
	}
}

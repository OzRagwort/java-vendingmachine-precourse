package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class VendingMachineTest extends NsTest {
	@DisplayName("보유 동전 개수 출력 기능 테스트")
	@Test
	void showCoinStateTest() {
		assertRandomNumberInListTest(
			() -> {
				run("450");
				VendingMachine vendingMachine = new VendingMachine();
				vendingMachine.initCoin();
				vendingMachine.showCoinState();
				assertThat(output()).contains(
					"자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개"
				);
			},
			100, 100, 100, 100, 50
		);
	}

	@Override
	protected void runMain() {
	}
}

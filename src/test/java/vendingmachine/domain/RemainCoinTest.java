package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemainCoinTest {
	@DisplayName("동전 무작위 생성 테스트")
	@Test
	void initCoinTest() {
		assertRandomNumberInListTest(
			() -> {
				RemainCoin coin = new RemainCoin();
				coin.initCoins(450);
				assertEquals(coin.getCount(500), 0);
				assertEquals(coin.getCount(100), 4);
				assertEquals(coin.getCount(50), 1);
				assertEquals(coin.getCount(10), 0);
			},
			100, 100, 100, 100, 50
		);
	}
}

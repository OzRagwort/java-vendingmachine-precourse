package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.enums.Coin;

public class CoinMapTest extends NsTest {
	@DisplayName("CoinMap 보유한 금액만큼의 무작위 동전 생성 기능 테스트")
	@Test
	void setRandomCoinMapTest() {
		assertRandomNumberInListTest(
			() -> {
				CoinMap coinMap = new CoinMap(300);
				assertEquals(coinMap.coinMap.get(Coin.COIN_500.get()), 0);
				assertEquals(coinMap.coinMap.get(Coin.COIN_100.get()), 1);
				assertEquals(coinMap.coinMap.get(Coin.COIN_50.get()), 2);
				assertEquals(coinMap.coinMap.get(Coin.COIN_10.get()), 10);
			},
			100, 50, 50, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
		);
	}

	@Override
	protected void runMain() {
	}
}

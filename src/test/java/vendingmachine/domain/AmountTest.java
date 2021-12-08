package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.enums.ErrorMessage;

public class AmountTest extends NsTest {
	private static final String ERROR_MESSAGE = ErrorMessage.ERROR_MESSAGE.get();

	@DisplayName("Amount get() 테스트")
	@Test
	void getTest() {
		String value = "100";
		Amount amount = new Amount(value);
		assertEquals(amount.get(), Integer.parseInt(value));
	}

	@DisplayName("Amount 숫자가 아닌 경우 예외 테스트")
	@Test
	void numberFormatExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Amount("ozragwort");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("Amount 금액이 0 이상이 아닌 경우 예외 테스트")
	@Test
	void outOfRangeExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Amount("-1");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("Amount 10으로 나누어 떨어지지 않는 경우 예외 테스트")
	@Test
	void ExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Amount("15");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
	}
}

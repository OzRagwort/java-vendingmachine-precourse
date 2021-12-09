package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.enums.ErrorMessage;

public class ProductTest extends NsTest {
	private static final String ERROR_MESSAGE = ErrorMessage.ERROR_MESSAGE.get();

	@DisplayName("Product 이름에 (,[];)가 있고 형식이 맞는 경우 테스트")
	@Test
	void nameExceptionTest() {
		String[] inputs = new String[]{
			"[a,bc,150,20]",
			"[a[bc,150,20]",
			"[a]bc,150,20]",
			"[a;bc,150,20]"
		};
		for (String input : inputs) {
			new Product(input);
		}
		assertThat(output()).doesNotContain(ERROR_MESSAGE);
	}

	@DisplayName("Product 가격이 문자열인 경우 예외 테스트")
	@Test
	void priceNotNumberExceptionTest() {
		String input = "[abc,ragwort,20]";
		assertThrows(IllegalArgumentException.class, () -> {
			new Product(input);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("Product 가격이 최저 가격 미만인 경우 예외 테스트")
	@Test
	void priceLowerThanMinimumPriceExceptionTest() {
		String input = "[abc,0,20]";
		assertThrows(IllegalArgumentException.class, () -> {
			new Product(input);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("Product 가격이 10으로 나누어 떨어지지 않는 경우 예외 테스트")
	@Test
	void priceDivisibleBy10ExceptionTest() {
		String input = "[abc,215,20]";
		assertThrows(IllegalArgumentException.class, () -> {
			new Product(input);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("Product 수량이 문자열인 경우 예외 테스트")
	@Test
	void quantityNotNumberExceptionTest() {
		String input = "[abc,150,ragwort]";
		assertThrows(IllegalArgumentException.class, () -> {
			new Product(input);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("Product 수량이 음수인 경우 예외 테스트")
	@Test
	void quantityLowerThanZeroExceptionTest() {
		String input = "[abc,150,-1]";
		assertThrows(IllegalArgumentException.class, () -> {
			new Product(input);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
	}
}

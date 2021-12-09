package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.enums.ErrorMessage;

public class ProductsTest extends NsTest {
	private static final String ERROR_MESSAGE = ErrorMessage.ERROR_MESSAGE.get();

	@DisplayName("Products 기능 테스트")
	@Test
	void nameExceptionTest() {
		String input = "[콜;라,1500,20];[사이다,1000,10];[환타,2000,30]";
		new Products(input);
		assertThat(output()).doesNotContain(ERROR_MESSAGE);
	}

	// @DisplayName("Product 가격이 문자열인 경우 예외 테스트")
	// @Test
	// void priceNotNumberExceptionTest() {
	// 	String input = "[abc,ragwort,20]";
	// 	assertThrows(IllegalArgumentException.class, () -> {
	// 		new Product(input);
	// 		assertThat(output()).contains(ERROR_MESSAGE);
	// 	});
	// }

	@Override
	protected void runMain() {
	}
}

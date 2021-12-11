package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {
	private static final String PRODUCT_INFORMATION = "[콜라,1500,20]";
	private static final String PRODUCT_REGEX = "\\[(.*),([0-9]*),([0-9]*)]";
	private static final Pattern PATTERN = Pattern.compile(PRODUCT_REGEX);
	private static final String NAME = "콜라";
	private static final int PRICE = 1500;
	private static final int QUANTITY = 20;

	@DisplayName("상품 구매 시 상품 개수 감소 테스트")
	@Test
	void sellProductsTest() {
		Product product = new Product(PRODUCT_INFORMATION, PATTERN);

		product.sell();

		assertTrue(product.isSameQuantity(QUANTITY - 1));
	}
}

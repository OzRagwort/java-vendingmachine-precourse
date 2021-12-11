package vendingmachine.service;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.ProductName;
import vendingmachine.domain.Products;
import vendingmachine.dto.AddProductsDto;
import vendingmachine.dto.SellProductDto;

public class VendingMachineServiceTest extends NsTest {
	private static final String ADD_PRODUCTS_MESSAGE = "[콜라,1500,20];[사이다,1000,10]";
	private static final String FIRST_ADD_PRODUCTS = "콜라";
	private static final String SECOND_ADD_PRODUCTS = "사이다";
	private static final String INPUT_MONEY = "3000";
	private static final String COKE_COST = "1500";

	@DisplayName("상품 등록 기능 테스트")
	@Test
	void addProductsTest() {
		assertSimpleTest(
			() -> {
				run(ADD_PRODUCTS_MESSAGE);
				VendingMachineService service = new VendingMachineService();
				Products products = new Products();
				Products newProducts = new Products();
				newProducts.addByString(readLine());

				products = service
					.registerProducts(new AddProductsDto(products, newProducts))
					.getProducts();

				assertEquals(products.getProducts().size(), 2);
				assertEquals(products.getProducts().get(0).getName(), FIRST_ADD_PRODUCTS);
				assertEquals(products.getProducts().get(1).getName(), SECOND_ADD_PRODUCTS);
			}
		);
	}

	@DisplayName("상품 구매 기능 테스트")
	@Test
	void sellProductsTest() {
		assertSimpleTest(
			() -> {
				VendingMachineService service = new VendingMachineService();
				Products products = new Products();
				products.addByString(ADD_PRODUCTS_MESSAGE);
				int inputMoney = Integer.parseInt(INPUT_MONEY);
				int cokeCost = Integer.parseInt(COKE_COST);
				SellProductDto sellProductDto = new SellProductDto(
					products, new ProductName(FIRST_ADD_PRODUCTS), inputMoney);

				int remainMoney = service.sellProduct(sellProductDto).getInputMoney();

				assertEquals(remainMoney, inputMoney - cokeCost);
			}
		);
	}

	@Override
	protected void runMain() {
	}
}

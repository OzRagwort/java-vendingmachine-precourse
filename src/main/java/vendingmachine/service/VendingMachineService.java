package vendingmachine.service;

import vendingmachine.domain.Products;
import vendingmachine.domain.Coins;
import vendingmachine.dto.AddProductsDto;
import vendingmachine.dto.CanSellDto;
import vendingmachine.dto.InitCoinDto;
import vendingmachine.dto.RequestChangesDto;
import vendingmachine.dto.ResponseChangesDto;
import vendingmachine.dto.SellProductResultDto;
import vendingmachine.dto.ProductsDto;
import vendingmachine.dto.SellProductDto;

public class VendingMachineService {
	public VendingMachineService() {
	}

	public void initCoin(InitCoinDto initCoinDto) {
		Coins coins = initCoinDto.getCoins();
		int totalAmount = initCoinDto.getTotalAmount().get();
		coins.initCoins(totalAmount);
	}

	public ProductsDto registerProducts(AddProductsDto addProductsDto) {
		Products products = addProductsDto.getProducts();
		Products newProducts = addProductsDto.getNewProducts();
		if (products.canRegister(newProducts)) {
			products.registerAll(newProducts);
		}
		return new ProductsDto(products);
	}

	public boolean canSell(CanSellDto canSellDto) {
		Products products = canSellDto.getProducts();
		int inputMoney = canSellDto.getInputMoney();
		return products.canSell(inputMoney);
	}

	public SellProductResultDto sellProduct(SellProductDto sellProductDto) {
		Products products = sellProductDto.getProducts();
		int remainMoney = products.sellProduct(
			sellProductDto.getName(),
			sellProductDto.getInputMoney());
		return new SellProductResultDto(remainMoney);
	}

	public ResponseChangesDto calculateChange(RequestChangesDto requestChangesDto) {
		Coins coins = requestChangesDto.getCoins();
		int money = requestChangesDto.getMoney();
		return coins.calculateChange(money);
	}
}

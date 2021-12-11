package vendingmachine.service;

import vendingmachine.domain.Products;
import vendingmachine.domain.RemainCoin;
import vendingmachine.dto.AddProductsDto;
import vendingmachine.dto.InitCoinDto;
import vendingmachine.dto.SellProductResultDto;
import vendingmachine.dto.ProductsDto;
import vendingmachine.dto.SellProductDto;

public class VendingMachineService {
	public VendingMachineService() {
	}

	public void initCoin(RemainCoin coins, InitCoinDto initCoinDto) {
		int totalAmount = initCoinDto.getTotalAmount();
		coins.initCoins(totalAmount);
	}

	public ProductsDto addProducts(AddProductsDto addProductsDto) {
		Products products = addProductsDto.getProducts();
		Products newProducts = addProductsDto.getNewProducts();
		products.addAll(newProducts);
		return new ProductsDto(products);
	}

	public SellProductResultDto sellProduct(SellProductDto sellProductDto) {
		Products products = sellProductDto.getProducts();
		int remainMoney = products.sellProduct(
			sellProductDto.getName(),
			sellProductDto.getInputMoney());
		return new SellProductResultDto(remainMoney);
	}
}

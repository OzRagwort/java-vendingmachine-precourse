package vendingmachine.service;

import vendingmachine.domain.Products;
import vendingmachine.domain.RemainCoin;
import vendingmachine.dto.AddProductsDto;
import vendingmachine.dto.InitCoinDto;
import vendingmachine.dto.ProductsDto;

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
}

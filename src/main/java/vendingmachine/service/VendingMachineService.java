package vendingmachine.service;

import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.Money;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.Products;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductDto;
import vendingmachine.dto.ResponseCoinQuantityDto;

public class VendingMachineService {
	private final CoinRepository coinRepository;
	private final ProductRepository productRepository;
	private final MoneyRepository moneyRepository;

	public VendingMachineService() {
		coinRepository = new CoinRepository();
		productRepository = new ProductRepository();
		moneyRepository = new MoneyRepository();
	}

	public void setupCoin(RequestHoldingMoneyDto requestHoldingMoneyDto) {
		Money money = requestHoldingMoneyDto.getMoney();
		coinRepository.addMoney(money);
	}

	public ResponseCoinQuantityDto getCoinQuantity() {
		return new ResponseCoinQuantityDto(coinRepository.getCoinQuantity());
	}

	public void registerProduct(RequestRegisterProductDto requestRegisterProductDto) {
		Products products = requestRegisterProductDto.getProducts();
		productRepository.addAll(products);
	}

	public void insertMoney(RequestInsertMoneyDto requestInsertMoneyDto) {
		Money money = requestInsertMoneyDto.getMoney();
		moneyRepository.add(money);
	}
}

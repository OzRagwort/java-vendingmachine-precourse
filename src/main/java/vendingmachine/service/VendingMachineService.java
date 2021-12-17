package vendingmachine.service;

import vendingmachine.domain.Change;
import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.Money;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Name;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.Products;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductDto;
import vendingmachine.dto.RequestSellProductDto;
import vendingmachine.dto.ResponseCoinQuantityDto;
import vendingmachine.dto.ResponsePayMoneyDto;
import vendingmachine.dto.ResponseReturnChangeDto;

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

	public ResponsePayMoneyDto getPayMoney() {
		return new ResponsePayMoneyDto(moneyRepository.getMoney());
	}

	public void sellProduct(RequestSellProductDto requestSellProductDto) {
		Name name = requestSellProductDto.getName();
		Product product = productRepository.findByName(name);
		moneyRepository.sell(product);
		product.sell();
	}

	public boolean hasSellProduct() {
		Money money = moneyRepository.getMoney();
		return productRepository.hasSellProduct(money);
	}

	public ResponseReturnChangeDto returnChange() {
		Change change = coinRepository.returnChange(moneyRepository);
		return new ResponseReturnChangeDto(change);
	}
}

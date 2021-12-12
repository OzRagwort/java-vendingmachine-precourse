package vendingmachine.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.List;

import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.Money;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Name;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.Products;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductsDto;
import vendingmachine.dto.RequestSellProductDto;
import vendingmachine.dto.ResponseAllCoinQuantity;
import vendingmachine.dto.ResponseMoneyDto;
import vendingmachine.enums.Coin;

public class VendingMachineService {
	public VendingMachineService() {
	}

	public void initCoinRepository(RequestHoldingMoneyDto requestHoldingMoneyDto) {
		int money = requestHoldingMoneyDto.getMoney().get();
		List<Integer> amounts = Coin.getAmounts();
		while (money > 0) {
			int randomAmount = pickNumberInList(amounts);
			if (randomAmount <= money) {
				money -= randomAmount;
				CoinRepository.addOneQuantityByAmount(randomAmount);
			}
		}
	}

	public ResponseAllCoinQuantity getAllCoinQuantity() {
		return new ResponseAllCoinQuantity(CoinRepository.findAll());
	}

	public void registerProducts(RequestRegisterProductsDto requestHoldingMoneyDto) {
		Products products = requestHoldingMoneyDto.getProducts();
		products.save();
	}

	public void insertMoney(RequestInsertMoneyDto requestInsertMoneyDto) {
		Money money = requestInsertMoneyDto.getMoney();
		MoneyRepository.add(money);
	}

	public ResponseMoneyDto findMoney() {
		Money money = MoneyRepository.get();
		return new ResponseMoneyDto(money);
	}

	public void sellProduct(RequestSellProductDto requestSellProductDto) {
		Name name = requestSellProductDto.getName();
		Product product = ProductRepository.findByName(name);
		product.sell();
	}

	public boolean canSell() {
		return ProductRepository.canSell();
	}
}

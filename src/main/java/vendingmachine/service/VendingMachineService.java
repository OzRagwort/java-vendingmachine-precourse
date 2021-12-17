package vendingmachine.service;

import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.Money;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.ResponseCoinQuantityDto;

public class VendingMachineService {
	private final CoinRepository coinRepository;

	public VendingMachineService() {
		coinRepository = new CoinRepository();
	}

	public void setupCoin(RequestHoldingMoneyDto requestHoldingMoneyDto) {
		Money money = requestHoldingMoneyDto.getMoney();
		coinRepository.addMoney(money);
	}

	public ResponseCoinQuantityDto getCoinQuantity() {
		return new ResponseCoinQuantityDto(coinRepository.getCoinQuantity());
	}
}

package vendingmachine.service;

import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.Money;
import vendingmachine.dto.RequestHoldingMoneyDto;

public class VendingMachineService {
	private final CoinRepository coinRepository;

	public VendingMachineService() {
		coinRepository = new CoinRepository();
	}

	public void setupCoin(RequestHoldingMoneyDto requestHoldingMoneyDto) {
		Money money = requestHoldingMoneyDto.getMoney();
		coinRepository.addMoney(money);
	}
}

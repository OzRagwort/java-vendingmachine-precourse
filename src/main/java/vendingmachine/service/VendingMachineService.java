package vendingmachine.service;

import vendingmachine.domain.RemainCoin;
import vendingmachine.dto.InitCoinDto;

public class VendingMachineService {
	public VendingMachineService() {
	}

	public void initCoin(RemainCoin coins, InitCoinDto initCoinDto) {
		int totalAmount = initCoinDto.getTotalAmount();
		coins.initCoins(totalAmount);
	}
}

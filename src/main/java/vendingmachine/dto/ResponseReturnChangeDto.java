package vendingmachine.dto;

import vendingmachine.domain.Change;

public class ResponseReturnChangeDto {
	private Change change;

	public ResponseReturnChangeDto(Change change) {
		this.change = change;
	}

	public Change getChange() {
		return change;
	}
}

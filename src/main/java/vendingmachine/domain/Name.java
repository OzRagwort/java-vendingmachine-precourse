package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Name {
	private static final int MINIMUM_LENGTH = 1;

	private String name;

	public Name(String name) {
		validateLength(name);
		this.name = name;
	}

	public String get() {
		return name;
	}

	public boolean isSame(Name name) {
		return this.name.equals(name.name);
	}

	private void validateLength(String name) {
		if (name.length() < MINIMUM_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_SO_SHORT_ERROR.get());
		}
	}
}

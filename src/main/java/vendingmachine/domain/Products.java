package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Products {
	List<Product> products = new ArrayList<>();

	public Products(String input) {
		// String regex = "^(\\[.*,[0-9]*,[0-9]*]);(\\[.*,[0-9]*,[0-9]*])";
		String regex = "(^\\[.*,[0-9]*,[0-9]*])";
		// \[.*,[0-9]*,[0-9]*\]
		// String[] s = input.split(regex);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			String all = matcher.group();
			String all1 = matcher.group(1);
			String all2 = matcher.group(2);
			String all3 = matcher.group(3);
			System.out.println();
		}
	}
}

package vendingmachine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.controller.MachineController;

public class Application {
	public static void main(String[] args) {
		MachineController controller = new MachineController();

		String regex = "^\\[(.*),([0-9]*),([0-9]*)]";
		String s = "[abc,123,456]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			String a0 = matcher.group(0);
			String a1 = matcher.group(1);
			String a2 = matcher.group(2);
			String a3 = matcher.group(3);
		}
	}
}

package by.epam.lab02.service.validator;

import by.epam.lab02.bean.Text;

public class Validator {

	public static boolean validateText(Text text) {
		if(text == null) {
			return false;
		}
		return true;
	}

	public static boolean validateTextAndWordLength(Text text, int length) {
		if(text == null) {
			return false;
		}else if(length < 1) {
			return false;
		}
		return true;
	}
}

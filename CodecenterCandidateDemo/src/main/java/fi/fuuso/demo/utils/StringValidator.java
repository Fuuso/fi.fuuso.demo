package fi.fuuso.demo.utils;


public class StringValidator {

	public static String cleanString(String input) {
		if(input != null){
			return input.replaceAll("\\<.*?>", "").trim();
		} else {
			return "";
		}
	}
	
	public static boolean validateString(String input) {
		return !input.isEmpty();
	}
	
}

package model;

public class Utilities {

	public static boolean validaCnh(String cnh) {
		if(cnh.matches("A") || cnh.matches("B") || cnh.matches("C") || cnh.matches("D") || String.valueOf(cnh).matches("^null|$")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean validaCelular(String celular) {
		if(celular.matches("\\d{11}") || String.valueOf(celular).matches("^null|$")) {
			return true;
		} else {
			return false;
		}
		
	}
	
}


//(cnh.matches("A,B") || cnh.matches("B,A") || cnh.matches("A,C") || cnh.matches("C,A") || cnh.matches("A,D") ||cnh.matches("D,A") ||
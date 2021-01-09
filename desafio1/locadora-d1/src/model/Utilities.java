package model;

import java.text.SimpleDateFormat;
import java.time.Year;
//import java.util.Arrays;
import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;


public class Utilities {

	public static boolean validarCnh(String cnh) {
		
		if(cnh.toUpperCase().matches("A") || cnh.toUpperCase().matches("B") || cnh.toUpperCase().matches("C") || cnh.toUpperCase().matches("D") || String.valueOf(cnh).matches("^null|$")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean validarMotorista(Cliente c, Veiculo v) {
		String b = "B";
		String ce = "C";
		String d = "D";
		
		if(c.getCnh().contains(v.getCategoria()) || v.getCategoria().contains(c.getCnh()) || (c.getCnh().contains(b) && v.getCategoria().contains(b) || (v.getCategoria().matches(b) && c.getCnh().contains(b))) || (c.getCnh().contains(ce) && v.getCategoria().contains(ce) || (v.getCategoria().matches(ce) && c.getCnh().contains(ce))) || (c.getCnh().contains(d) && v.getCategoria().contains(d) || (v.getCategoria().matches(d) && c.getCnh().contains(d))) ) {
			return true;
		} else {
			return false;
		}
		
	
	}
	
	public static boolean validarCelular(String celular) {
		if(celular.matches("\\d{11}") || String.valueOf(celular).matches("^null|$")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean validarAnoFabricacao(int ano){
		
		int anoAtual = Year.now().getValue();
		int anoMinimo = anoAtual-20;
		
		if(ano > anoMinimo && ano <= anoAtual) {
			return true;
		}
		
		return false;
	}
	
	public static boolean validarPlaca(String placa){
		
		if (placa.matches("[A-Za-z]{3}\\d{4}")){
			return true;
		}
		
		return false;
	}
	
	public static String formataData(Date data){
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = fmt.format(data);
		
		return dataFormatada;
	}
	
	public static String formataDataDia(Date data){
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = fmt.format(data);
		
		return dataFormatada;
	}
	
}

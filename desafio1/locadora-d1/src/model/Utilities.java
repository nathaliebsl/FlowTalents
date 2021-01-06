package model;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class Utilities {

	public static boolean validarCnh(String cnh) {
		if(cnh.matches("A") || cnh.matches("B") || cnh.matches("C") || cnh.matches("D") || String.valueOf(cnh).matches("^null|$")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean validarMotorista(Cliente c, Veiculo v) {
		if(c.getCnh().matches(v.getCategoria()) || v.getCategoria().contains(c.getCnh()) || c.getCnh().contains(v.getCategoria()) ) {
			return true;
		} else {
			return false;
		}
		
	}
	
//	public static boolean validarMotorista(Cliente c, Veiculo v) {
//		if(String.valueOf(c.getCnh()) == v.getCategoria() || String.valueOf(c.getCnh()).contains(v.getCategoria())) {
//			return true;
//		} else {
//			return false;
//		}
//		
//	}
	
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

package model;

import java.text.SimpleDateFormat;
import java.time.Year;
//import java.util.Arrays;
import java.util.Date;
//import java.util.Iterator;
//import java.lang.Iterable;

public class Utilities {

	public static boolean validarCnh(String cnh) {
		if(cnh.matches("A") || cnh.matches("B") || cnh.matches("C") || cnh.matches("D") || String.valueOf(cnh).matches("^null|$")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean validarMotorista(Cliente c, Veiculo v) {
		if(v.getCategoria().regionMatches(true, 0, c.getCnh(), 0, 1)); {
			return true;
		} 	
	
	}
//		String[] cnh = (c.getCnh());
//		cnh = Arrays.asList(cnh);
//		for(Cliente client :  ) {
//			Iterator<String> cnh = stringList.iterator(); // Aqui foi normal. Ou seja, como ele já estava fazendo.
//		}
//		    for(Veiculo vehicle : cat)
//		        if(c.equals(v))
//		            System.out.println("O [" + c.getCnh() + "] existe nas 2 listas");
//		if(c.getCnh().matches(v.getCategoria()) || v.getCategoria().contains(c.getCnh()) || c.getCnh().contains(v.getCategoria()) || c.getCnh() == v.getCategoria() ) {
//			return true;
//		} else {
//			return false;
//		}
		
	
	//for(int i = 0; i < this.classeCnh.length; i++) {
//		if(this.classeCnh[i] == null) {
//			this.classeCnh[i] = cnh;
//			break;
	
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

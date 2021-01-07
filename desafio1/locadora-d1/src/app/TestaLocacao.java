package app;

import model.*;
//import system.*;

public class TestaLocacao {
	
	public static void main(String[] args) throws Exception {
		
//		Carro c1 = new Carro("CCC1111", "honda", 2020, "verde", 4, 'S', 'A', "eletrica");
		Moto m1 = new Moto("MMM1111", "honda", 2020, "p", 100);
		System.out.println(m1.toString());
		
		Cliente cli = new Cliente("99999999999", "A");
		System.out.println(cli.getCnh());
		
	
		
//		System.out.println(cli.getCnh().contentEquals(c1.getCategoria()));
//		System.out.println(c1.getCategoria().contentEquals(cli.getCnh()));
//		
//		System.out.println(cli.getCnh().contains(c1.getCategoria()));
//		System.out.println(c1.getCategoria().contains(cli.getCnh()));
//		
//		System.out.println(c1.getCategoria().equals(cli.getCnh()));
//		
//		System.out.println(c1.getCategoria().equalsIgnoreCase(cli.getCnh()));
//		
//		System.out.println((c1.getCategoria()).indexOf(cli.getCnh()));
//		
//		System.out.println((c1.getCategoria()).intern().contains(cli.getCnh()));
//		
//		System.out.println((c1.getCategoria().matches(cli.getCnh())));
//		
//		System.out.println((c1.getCategoria().regionMatches(0, cli.getCnh(), 0, 1)));
//		
//	
		
		
//		Locacao loc = new Locacao()

//		system.cadastrarCarro("CCC1111", "honda", 2020, "verde", 4, 'S', 'A', "eletrica");
//		system.cadastrarCarro("CCC1111", "honda", 2020, "verde", 4, 'S', 'A', "eletrica");
//		
//		system.cadastrarCliente("99999999999", "A");
//		
//		system.locarVeiculo('2021/2/21', '2021/01/21 12:30:00', "99999999999", "CCC1111");
//		
//		
//		Utilities.formataData("21/12");
//		
	}
}

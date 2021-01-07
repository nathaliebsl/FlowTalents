package app;

import model.*;

//import model.Moto;

public class TesteVeiculo {

	public static void main(String[] args) throws Exception {
	
//			Carro c1 = new Carro("CCC1111", "", 3021, "verde", 4, 'S', 'A', "elétrica");
		
			Moto m1 = new Moto("MMM1111", "honda", 2010, "preta", 150);
			
			Onibus o1 = new Onibus("OOO1111", "volvo", 2015, "branco", 50);
			
			Caminhao t1 = new Caminhao("TTT1111", "volvo", 2020, "branco", 1000);
			
			
//			System.out.println(c1.toString());
			System.out.println(m1.toString());
			System.out.println(o1.toString());
			System.out.println(t1.toString());
			

		
			

	}

}

package app;

import model.Carro;
import model.Moto;

public class TesteVeiculo {

	public static void main(String[] args) throws Exception {
	
			Carro c1 = new Carro("IVV-2222", "Fiat");
			
			System.out.println(c1.getPlaca());
			
			System.out.println(c1.getCategoria());
			
			Moto m1 = new Moto("IXZ-2220", "Honda", 22);
			
			System.out.println(m1.getPlaca());
			System.out.println(m1.getCategoria());
			System.out.println(c1.toString());
		
			

	}

}

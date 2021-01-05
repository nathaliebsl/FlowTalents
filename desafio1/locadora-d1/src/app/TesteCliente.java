package app;

import model.Cliente;


public class TesteCliente {
	
	public static void main(String[] args) throws Exception {
		
		Cliente c1 = new Cliente("51982175925", "A");
		
		c1.addCnh("A");
		
		System.out.println(c1.toString());
		
		
	}

}

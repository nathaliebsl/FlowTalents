package model;

import java.util.Arrays;

public class Onibus extends Veiculo {
	
	private int assentos;
	private String[] catOnibus = {"D"};

	public Onibus(String placa, String marca, int assentos) {
		super(placa, marca);
		
	}

	
	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	
	
	@Override
	public String getCategoria() {
		return Arrays.toString(this.catOnibus);
	}
	
//	@Override
//	public String toString() {
//		return "Onibus [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ......]";
//	}

}

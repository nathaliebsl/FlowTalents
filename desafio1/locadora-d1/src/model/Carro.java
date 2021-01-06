package model;

import java.util.Arrays;

public class Carro extends Veiculo {
	
	private int portas;
	private char ac;
	private char cambio;
	private String direcao;
	private String[] catCarro = {"A", "C", "D"};
	
	
	public Carro (String placa, String marca, int portas, char ac, char cambio, String direcao) {
		super(placa, marca);
		
	
	}

	
	@Override
	public String getCategoria() {
		return Arrays.toString(this.catCarro);
	}
	
	
	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public char getAc() {
		return ac;
	}

	public void setAc(char ac) {
		this.ac = ac;
	}

	public char getCambio() {
		return cambio;
	}

	public void setCambio(char cambio) {
		this.cambio = cambio;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	
	@Override
	public String toString() {
		return "Carro [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ......]";
	}
	

}

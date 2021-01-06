package model;

import java.util.Arrays;

public class Carro extends Veiculo {
	
	private int portas;
	private char ac;
	private char cambio;
	private String direcao;
	private String[] catCarro = {"A", "C", "D"};
	
	
	public Carro (String placa, String marca, int anoFabricacao, String cor, int portas, char ac, char cambio, String direcao) throws Exception {
		super(placa, marca, anoFabricacao, cor);
		this.portas = portas;
		this.ac = ac;
		this.cambio = cambio;
		this.direcao = direcao;

	}

	
	@Override
	public String getCategoria() {
		return Arrays.toString(catCarro);
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
		return "Carro [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ano de fabricação=" + this.getAnoFabricacao() + ", cor= " + this.getCor() +  ", portas=" + this.getPortas() + ", AC=" + this.getAc() + ", cambio=" + this.getCambio() + ", direção=" + this.getDirecao() +" ]";
	}
	

}

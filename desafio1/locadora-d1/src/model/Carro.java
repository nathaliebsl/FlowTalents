package model;

import java.util.Arrays;

public class Carro extends Veiculo {
	
	private int portas;
	private String ac;
	private String cambio;
	private String direcao;
	private String[] catCarro = {"A", "C", "D"};
	
	
	public Carro() {
		
	}
	
	public Carro (String placa, String marca) {
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

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	
//	@Override
//	public String toString() {
//		return "Carro [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ......]";
//	}
	

}

package model;

import java.util.Arrays;

public class Caminhao extends Veiculo {
	
	private int capacidade;
	private String[] catCaminhao = {"C"};
	
	public Caminhao(String placa, String marca, int anoFabricacao, String cor, int capacidade) {
		super(placa, marca, anoFabricacao, cor);
		this.capacidade = capacidade;
		
	}
	

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	@Override
	public String getCategoria() {
		return Arrays.toString(this.catCaminhao);
	}
	
	@Override
	public String toString() {
		return "Caminhao [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ano de fabricação=" + this.getAnoFabricacao() + ", cor= " + this.getCor() + ", capacidade=" + this.getCapacidade() + "]";
	}

}

package model;

public class Caminhao extends Veiculo {
	
	private int capacidade;
	private String categoria = "C";
	
	public Caminhao(String placa, String marca, int anoFabricacao, String cor, int capacidade) {
		super(placa, marca, anoFabricacao, cor);
		this.capacidade = capacidade;
		
	}
	
	
	@Override
	public String getCategoria() {
		return this.categoria;
	}
	
	@Override
	public String toString() {
		return "Caminhao [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ano de fabricação=" + this.getAnoFabricacao() + ", cor= " + this.getCor() + ", capacidade=" + this.getCapacidade() + "]";
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

}

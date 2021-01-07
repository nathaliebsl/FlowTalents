package model;

public class Onibus extends Veiculo {
	
	private int assentos;
	private String categoria = "D";

	public Onibus(String placa, String marca, int anoFabricacao, String cor, int assentos) {
		super(placa, marca, anoFabricacao, cor);
		this.assentos = assentos;
		
	}

	
	@Override
	public String getCategoria() {
		return this.categoria;
	}
	
	@Override
	public String toString() {
		return "Onibus [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ano de fabricação=" + this.getAnoFabricacao() + ", cor= " + this.getCor() + ", assentos=" + this.getAssentos() + "]";
	}
	
	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

}

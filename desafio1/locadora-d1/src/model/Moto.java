package model;

public class Moto extends Veiculo {
	
	private int cilindradas;
//	private String categoria = "A";
	
	public Moto(String placa, String marca, int anoFabricacao, String cor, int cilindradas) {
		super(placa, marca, anoFabricacao, cor);
		this.cilindradas = cilindradas;
		
	}
	
	
	@Override
	public String getCategoria() {
		String categoria = "A"; 
		return categoria;
	}
	
	@Override
	public String toString() {
		return "Moto [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ano de fabricação=" + this.getAnoFabricacao() + ", cor= " + this.getCor() + ", cilindradas=" + this.getCilindradas() + "]";
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}
	
}

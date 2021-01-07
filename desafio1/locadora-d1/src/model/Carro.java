package model;

public class Carro extends Veiculo {
	
	private int portas;
	private String ac;
	private String cambio;
	private String direcao;
	private String categoria = "B";
//	private String[] catCarro = {"A", "C", "D"};
	
	
	public Carro (String placa, String marca, int anoFabricacao, String cor, int portas, String ac, String cambio, String direcao) throws Exception {
		super(placa, marca, anoFabricacao, cor);
		this.portas = portas;
		this.ac = ac;
		this.cambio = cambio;
		this.direcao = direcao;
	
	}
	
	
	@Override
	public String getCategoria() {
		return this.categoria;
	}
	
	@Override
	public String toString() {
		return "Carro [placa=" + this.getPlaca() + ", marca=" + this.getMarca() + ", ano de fabricação=" + this.getAnoFabricacao() + ", cor= " + this.getCor() +  ", portas=" + this.getPortas() + ", AC=" + this.getAc() + ", cambio=" + this.getCambio() + ", direção=" + this.getDirecao() +" ]";
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
	

}

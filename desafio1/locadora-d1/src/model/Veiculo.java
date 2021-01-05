package model;


import java.time.Year;
import java.util.Arrays;

public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private int anoFabricacao;
	private String cor;
	private String[] categoria;
	//private boolean alugado;
	//private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

	
	public Veiculo () { 
		
	}
	
	public Veiculo (String placa, String marca) {
		
		if(placa != null) {
			this.placa = placa;
		} else {
			System.out.println("Informe uma placa válida");
			return;
		}
		
		if(marca != null) {
			this.marca = marca;
		} else {
			System.out.println("Informe uma marca válida");
			return;
		}
		
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(int anoFabricacao) {
		int anoAtual = Year.now().getValue();
		int anoMinimo = 2000;
		
		if(anoFabricacao > anoMinimo && anoFabricacao < anoAtual) {
			this.anoFabricacao = anoFabricacao;
		} else {
			System.out.println("Informe um ano válido");
			return;
		}
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		if(cor != null) {
			this.cor = cor;
		} else {
			System.out.println("Informe uma cor válida");
			return;
		}
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCategoria() {
		return Arrays.toString(this.categoria);
	}


	
}

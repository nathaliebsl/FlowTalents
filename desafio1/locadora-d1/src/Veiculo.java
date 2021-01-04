public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private int ano;
	private String cor;
	
	int anoAtual = 2021;
	int anoMinimo = 2000;
	
	public Veiculo () { 
		
	}
	
	public Veiculo (String placa, String marca, int ano, String cor) {
		
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
		
		if(ano >= anoMinimo && ano <= anoAtual) {
			this.ano = ano;
		} else {
			System.out.println("Informe um ano válido");
			return;
		}
		
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	
}

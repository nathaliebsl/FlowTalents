package model;

import java.util.ArrayList;

public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private int anoFabricacao;
	private String cor;
	private String categoria;
	private boolean locado;
	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

	
	public Veiculo () { 
		
	}
	
	public Veiculo (String placa, String marca, int anoFabricacao, String cor) {
		
		this.placa = placa;
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		
		locado = false;
		
	}
	
	public String getMarca() {
		return marca.toUpperCase();
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(int anoFabricacao) {
		
		if(Utilities.validarAnoFabricacao(anoFabricacao)) {
			this.anoFabricacao = anoFabricacao;
		} else {
			System.out.println("Informe um ano válido");
			return;
		}
	}
	
	public String getCor() {
		return cor.toUpperCase();
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
		return placa.toUpperCase();
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCategoria() {
		return categoria.toUpperCase();
	}

	public boolean isLocado() {
		return locado;
	}
	
	public void setLocado(boolean locado) {
		this.locado = locado;
	}
	
	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}
	
	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	public void addLocacao(Locacao locacao){
		locacoes.add(locacao);
	}
	
	public Locacao localizarLocacao(int id) throws Exception{
		
		for(Locacao loc: locacoes){
			if(loc.getId() == id)
				return loc;
		}
		
		throw new Exception("Locação não cadastrada!");
	}
	
}

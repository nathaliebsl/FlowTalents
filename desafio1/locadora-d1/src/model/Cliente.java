package model;

import java.util.ArrayList;
import java.util.Arrays;

import java.lang.Exception;

public class Cliente {
	
	private String celular;
	private String[] classeCnh = {};
	private static int sequencia = 1;
	private int id;
	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	
	
	public Cliente(String celular, String cnh) {
		this.celular = celular;
		this.classeCnh = new String[classeCnh.length +1];
		this.classeCnh[this.classeCnh.length - 1] = cnh;
		this.id = sequencia++;
	}
	
	@Override
	public String toString() {
		return "Cliente id=" + this.getId() + "[WhatsApp=" + celular + ", Classe da CNH=" + Arrays.toString(this.classeCnh).toUpperCase() + ", Locações= " + locacoes.size() + "]";
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getCnh() {
		Arrays.sort(this.classeCnh);
		return Arrays.toString(this.classeCnh).toUpperCase();
	}
	
	public void addCnh(String cnh) {
		if(!Utilities.validarCnh(cnh)) {
			throw new IllegalArgumentException("Classe deve ser válida - A, B, C ou D");
		} 
		if(Utilities.validarCnh(cnh)) {	
			
			this.classeCnh = Arrays.copyOf(this.classeCnh, this.classeCnh.length +1);
			this.classeCnh[this.classeCnh.length - 1] = cnh;
			}

	}

	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}
	
	public void setLocacoes(ArrayList<Locacao> loc) {
		this.locacoes = loc;
	}
	
	public void addLocacao(Locacao loc){
		try{
			locacoes.add(loc);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Locacao localizarLocacao(int id) throws Exception {
		
		for(Locacao locacao: locacoes){
			if(locacao.getId() == id)
				return locacao;
		} throw new Exception("Aluguel não cadastrado!");
	}

	public int getId() {
		return id;
	}


}

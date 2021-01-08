package model;

import java.util.ArrayList;
import java.util.Arrays;

import java.lang.Exception;

public class Cliente {
	
	private String celular;
//	private ArrayList<String> classeCnh;
//	private boolean classeCnh;
	private String[] classeCnh = {};
	private static int sequencia = 1;
	private int id;
	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	
	
	public Cliente(String celular, String cnh) {
//		String c = cnh;
		this.celular = celular;
		this.classeCnh = new String[classeCnh.length +1];
		this.classeCnh[this.classeCnh.length - 1] = cnh;
//		ArrayList<String> classeCnh = new ArrayList<String>();
//		classeCnh.lenght;
//		classeCnh.add(c);
//		this.classeCnh.add(cnh);
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
//			this.classeCnh.add(cnh);
//			String add[] = new String[this.classeCnh.length+2];
//			for(int i = 0; i < this.classeCnh.length; i++) {
//				if(i==add.length-1){
//		            add[i] = cnh;
//		            add[i] = this.classeCnh[i];
//				}
//			
//				for(int i = 0; i < this.classeCnh.length; i++) {
//				  if(i==classeCnh.length-1){
//			            classeCnh[i]= cnh;
//				  }
				  
//				System.out.println(this.classeCnh.length);
//				this.classeCnh[i] = this.classeCnh[this.classeCnh.length - 1] = cnh;
//				this.classeCnh[this.classeCnh.length - 1] = cnh;
//				this.classeCnh.add(cnh);
//			}
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

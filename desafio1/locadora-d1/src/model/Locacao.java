package model;

import java.util.Date;


public class Locacao {
	
	private int id; //criar numero aleatorio (sequencia numerica)
	private Date datainicio;
	private Date datafim;
	private boolean finalizado;
	private Veiculo veiculo;
	private Cliente cliente;
	


	public Locacao(Date inicio, Date fim, Veiculo vehicle , Cliente client){
		//double diffTime = (fim.getTime() - inicio.getTime())/86400000; 
		datainicio = inicio;
		datafim = fim;
		veiculo = vehicle;
		cliente = client;
		finalizado = false;
	}
	
	@Override
	public String toString() {
		return "Locacao [id=" + id + ", datainicio=" + datainicio + ", datafim=" + datafim + ", finalizado=" + finalizado + ", Veiculo=" + veiculo.getPlaca() + ", cliente=" + cliente.getCelular()
				+ "]";
	}


	public int getId() {
		return id;
	}
	
//criar numero aleatorio - acho que nao precisa de set
//	public void setId(int id) {
//		this.id = id;
//	}
	
	public Date getDatainicio() {
		return datainicio;
	}
	
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	
	public Date getDatafim() {
		return datafim;
	}
	
	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	
	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	


}

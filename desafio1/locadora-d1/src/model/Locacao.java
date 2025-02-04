package model;

import java.util.Date;

public class Locacao {
	
	private static int sequencia = 0;
	private int id;
	private Date datainicio;
	private Date datafim;
	private boolean finalizado;
	private Veiculo veiculo;
	private Cliente cliente;
	
	

	public Locacao(int id, Date inicio, Date fim, Veiculo vehicle , Cliente client){
		this.id = sequencia++; 
		datainicio = inicio;
		datafim = fim;
		veiculo = vehicle;
		cliente = client; 
		finalizado = false;
	}
	
	@Override
	public String toString() {
		return "Locação [id=" + id + ", início=" + datainicio + ", prazo de devolução=" + datafim + ", Veículo=" + veiculo.getPlaca() + ", Cliente=" + cliente.getCelular()
				+ "]";
	}


	public int getId() {
		return id;
	}
	
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

	public Veiculo getVeiculo() {
		return veiculo;
	}
	

}

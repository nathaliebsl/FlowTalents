package model;

import java.util.Date;

//precisa alguns ajustes ainda para compilar.

public class Locacao {
	
	private static int sequencia = 0;
	private int id;
	private Date datainicio;
	private Date datafim;
	private boolean finalizado;
	private Veiculo veiculo;
	private Cliente cliente;
	
	

	public Locacao(Date inicio, Date fim, Veiculo vehicle , Cliente client){
		this.id = sequencia++; //cria sequencia numérica a cada nova locação
		datainicio = inicio;
		datafim = fim;
		veiculo = vehicle; //preciso puxar do Bc de veiculos?
		cliente = client; //preciso puxar do Bc de cliente?
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

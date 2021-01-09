package model;

import java.util.ArrayList;

public class Locadora {

	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	
	public Locadora(){
		
	}
	
	@Override
	public String toString() {
		return "Locadora [nome=" + nome + ", clientes=" + clientes + ", Veiculos=" + veiculos + ", locacoes=" + locacoes
				+ "]";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}
	
	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	public void addVeiculo(Veiculo vehicle){
		veiculos.add(vehicle);
	}
	
	public boolean veiculoCadastrado(String placa) throws Exception{
		
		for(Veiculo vehicle: veiculos){
			if(vehicle.getPlaca().equals(placa))
				return true;
		}
		
		return false;
	}
	
	
	public Veiculo localizarVeiculo(String placa) throws Exception {
		
		for(Veiculo v: veiculos){
			if(v.getPlaca().equals(placa.toUpperCase()))
				return v;
		}
		
		throw new Exception("Veículo não cadastrado!");
	}
	
	public void addCliente(Cliente client){
		clientes.add(client);
	}
	
	public boolean clienteCadastrado(String celular) throws Exception{
		
		for(Cliente client: clientes){
			if(client.getCelular().equals(celular))
				return true;
		}
		
		return false;
	}
	
	public Cliente localizarCliente(String celular) throws Exception{
		
		for(Cliente client: clientes){
			if(client.getCelular().equals(celular))
				return client;
		}
		
		throw new Exception("Cliente não cadastrado!");
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
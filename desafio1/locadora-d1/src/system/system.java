package system;

import model.*;

import java.util.ArrayList;
import java.util.Date;

public class system {
	
private static Locadora locadora = new Locadora();
	
	public static Cliente cadastrarCliente(String celular, String cnh) throws Exception{
		
		Cliente client = null;
		
		if(Utilities.validarCelular(celular)){
			try{
				locadora.localizarCliente(celular);
				throw new Exception("Cliente já cadastrado!");
			}
			catch (Exception e){
				client = new Cliente(celular, cnh);
				locadora.addCliente(client);
			}
		}
		else throw new Exception("Celular Inválido!");
		
		return client;
	}
	
	
	public static Carro cadastrarCarro(String placa, String marca, int anoFabricacao, String cor, int portas, char ac, char cambio, String direcao) throws Exception{
		
		Carro car = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				car = new Carro(placa, marca, anoFabricacao, cor, portas, ac, cambio, direcao);
				locadora.addVeiculo(car);
			}
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return null;
	}
	
	public static Moto cadastrarMoto(String placa, String marca, int anoFabricacao, String cor, int cilindradas) throws Exception{
		
		Moto bike = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				bike = new Moto(placa, marca, anoFabricacao, cor, cilindradas);
				locadora.addVeiculo(bike);
			}
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return null;
	}
	
	public static Onibus cadastrarOnibus(String placa, String marca, int anoFabricacao, String cor, int assentos) throws Exception{
		
		Onibus bus = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				bus = new Onibus(placa, marca, anoFabricacao, cor, assentos);
				locadora.addVeiculo(bus);
			}
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return null;
	}
	
	public static Caminhao cadastrarCaminhao(String placa, String marca, int anoFabricacao, String cor, int capacidade) throws Exception{
		
		Caminhao truck = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				truck = new Caminhao(placa, marca, anoFabricacao, cor, capacidade);
				locadora.addVeiculo(truck);
			}
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return null;
	}
	
	

	public static Locacao locarVeiculo(Date datainicio, Date datafinal, String celular, String placa) throws Exception{
		
		Locacao result  = null;
		
		if(datafinal.getTime() > datainicio.getTime())
		{
			if(Utilities.validarCelular(celular))
			{
				Cliente client = null;
				
				try{
					client = locadora.localizarCliente(celular);
					//String cnh = client.getCnh();
				
					if(Utilities.validarPlaca(placa)){
						Veiculo vehicle = null;
						
						try{
							vehicle = locadora.localizarVeiculo(placa);
							//String cat = vehicle.getCategoria();
							
							if(!Utilities.validarMotorista(client, vehicle)) {
									
							if(!vehicle.isLocado()) { //comparativo entre cnh do cliente e cat do veiculo
								int id = locadora.getLocacoes().size();
								result =  new Locacao(id, datainicio, datafinal, vehicle, client);
								locadora.addLocacao(result);
	
								vehicle.addLocacao(result);
								client.addLocacao(result);
								vehicle.setLocado(true);
							}
							else throw new Exception("Veículo está alugado");
							} 
							else throw new Exception("Cnh do Motorista não Compativel com Categoria do Veículo");
						}
						catch (Exception e){
							System.out.println(e.getMessage());
						}
						
					}else throw new Exception("Placa Inválida!");
					
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
					
			}else throw new Exception("Celular Inválido!");
		}else throw new Exception("Data final menor que inicial!");
		
		return result;
	}
	
	
	public static void encerrarLocacao(String placa) throws Exception{
		
		if(Utilities.validarPlaca(placa)){
			
			Veiculo vehicle = null;
			
			try{
				
				vehicle = locadora.localizarVeiculo(placa);
				
				if(vehicle.isLocado())
				{
					
					Date data = new Date();
					ArrayList<Locacao> listLocacoes = vehicle.getLocacoes();
					Locacao loc = listLocacoes.get(listLocacoes.size()-1);
					
					long di = loc.getDatainicio().getTime()/86400000;
					long now = data.getTime()/86400000;
					long df = loc.getDatafim().getTime()/86400000;
					
					
					
					//double diaria = aluguel.getDiaria();
					
					//double newValor = (df-di) <= 0 ?  (di-df)*diaria : (df-di)*2*diaria + aluguel.getValor();
					
					/* Paga no minimo uma diária caso o carro seja devolvido antes de 24h
					 * Preço mínimo do aluguel
					 */
					//aluguel.setValor(newValor > 0 ? newValor : diaria);
					loc.setFinalizado(true);
					vehicle.setLocado(false);
					System.out.println("Locação do veículo " + vehicle.toString() + "encerrada!"); //será que puxa os dados do veículo?
				}
				else throw new Exception("Veículo não está alugado!");
				
			}
			catch (Exception e){
				throw new Exception(e.getMessage());
			}
			
		}else throw new Exception("Placa inválida!");
		
	}
	
	
	public static String listarClientes() throws Exception{
		String ultimaLocacao = "";
		String stringClientes = "";
		ArrayList<Cliente> listaClientes = locadora.getClientes();
		
		if(!listaClientes.isEmpty()){
			for(Cliente client: listaClientes){
				ArrayList<Locacao> listaLocacoes = client.getLocacoes();
				
				if(!listaLocacoes.isEmpty()){
					Locacao loc = listaLocacoes.get(listaLocacoes.size()-1);
					ultimaLocacao = " Última locação: " + Utilities.formataData(loc.getDatainicio());
				}
				else ultimaLocacao = "";
				
				stringClientes+=("CNH: " + client.getCnh() + " Celular: " + client.getCelular() +  ultimaLocacao + ";" );
			}
		}
		else throw new Exception("Não existem clientes cadastrados!");
		
		return stringClientes;
	}
	
	
	public static String listarVeiculos() throws Exception{
		String stringVeiculos = "";
		ArrayList<Veiculo> listaVeiculos = locadora.getVeiculos();
		
		if(!listaVeiculos.isEmpty()){
			for(Veiculo vehicle: listaVeiculos){
				ArrayList<Locacao> listaLocacoes = vehicle.getLocacoes();
				String idCliente = vehicle.isLocado() ? " Cliente: " + listaLocacoes.get(listaLocacoes.size()-1).getCliente().getCelular() : "";
				stringVeiculos+="Placa:" + vehicle.getPlaca() + " Modelo:" + vehicle.getMarca() + idCliente + ";";
			}
		}
		else throw new Exception("Não existem carros cadastrados!");
		
		return stringVeiculos;
	}
	
	public static String listarLocacoesFinalizadas() throws Exception{
		String stringLocacoes = "";
		ArrayList<Locacao> listaLocacoes = locadora.getLocacoes();
		int days = 0;
		
		if(!listaLocacoes.isEmpty()){
			for(Locacao loc: listaLocacoes){
				if(loc.isFinalizado()){
					String dataInit = Utilities.formataData(loc.getDatainicio());
					String dataFim = Utilities.formataData(loc.getDatafim());
					
					days += Integer.parseInt(dataFim.split("/")[0]) - Integer.parseInt(dataInit.split("/")[0]);
					
					stringLocacoes+="ID:" + loc.getId() + " Veiculo:" + loc.getVeiculo().getPlaca() + " Cliente:" + 
							loc.getCliente().getCelular()  + " Inicio: " + 
							dataInit + " Fim: "  + dataFim + " Quantidade de dias de todos os alugueis: " + days + ";";
				}
			}
			
			if(stringLocacoes == "") throw new Exception("Não existem locacoes finalizadas");
		}
		else throw new Exception("Não exisem locacoes cadastradas!");
		
		return stringLocacoes;
	}
	
	public static String listarLocacoesHoje() throws Exception{
		String locacoesHoje = "";
		ArrayList<Locacao> listaLocacoes = locadora.getLocacoes();
		Date today = new Date();
		
		if(!listaLocacoes.isEmpty()){
			for(Locacao loc: listaLocacoes){
				Date fim = loc.getDatafim();
				
				if( Utilities.formataDataDia(today).equals(Utilities.formataDataDia(fim) ) && !loc.isFinalizado()){
					locacoesHoje+="ID:" + loc.getId() + " Carro: " + loc.getVeiculo().getPlaca() + " Cliente:" + 
							loc.getCliente().getCelular();
				}
			}
			
			if(locacoesHoje.equals("")) 
				throw new Exception("Não existem alugueis a serem finalizados hoje!");
			
		}else throw new Exception("Não existem alugueis cadastrados!");
		
		return locacoesHoje;
	}
	


}

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
	
	
	public static Carro cadastrarCarro(String placa, String marca, int portas, char ac, char cambio, String direcao) throws Exception{
		
		Carro car = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				car = new Carro(placa, marca, portas, ac, cambio, direcao);
				locadora.addVeiculo(car);
			}
		}
		else throw new Exception("Placa Inválida!");
		
		return null;
	}
	
	public static Moto cadastrarMoto(String placa, String marca, int cilindradas) throws Exception{
		
		Moto bike = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				bike = new Moto(placa, marca, cilindradas);
				locadora.addVeiculo(bike);
			}
		}
		else throw new Exception("Placa Inválida!");
		
		return null;
	}
	
	public static Onibus cadastrarOnibus(String placa, String marca, int assentos) throws Exception{
		
		Onibus bus = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				bus = new Onibus(placa, marca, assentos);
				locadora.addVeiculo(bus);
			}
		}
		else throw new Exception("Placa Inválida!");
		
		return null;
	}
	
	public static Caminhao cadastrarCaminhao(String placa, String marca, int capacidade) throws Exception{
		
		Caminhao truck = null;
		
		if(Utilities.validarPlaca(placa)){
			try{
				locadora.localizarVeiculo(placa);
				throw new Exception("Veiculo já cadastrado!");
			}
			catch (Exception e){
				truck = new Caminhao(placa, marca, capacidade);
				locadora.addVeiculo(truck);
			}
		}
		else throw new Exception("Placa Inválida!");
		
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
				
					if(Utilities.validarPlaca(placa)){
						Veiculo vehicle = null;
						
						try{
							vehicle = locadora.localizarVeiculo(placa);
							
							if(!vehicle.isLocado()){
								int id = locadora.getLocacoes().size();
								result =  new Locacao(id, datainicio, datafinal, vehicle, client);
								locadora.addLocacao(result);
	
								vehicle.addLocacao(result);
								client.addLocacao(result);
								vehicle.setLocado(true);
							}
							else throw new Exception("Veículo está alugado!");
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
//	
//	
//	public static String listarClientes() throws SystemException{
//		String ultimoAluguel = "";
//		String stringClientes = "";
//		ArrayList<Cliente> listaClientes = locadora.getClientes();
//		
//		if(!listaClientes.isEmpty()){
//			for(Cliente client: listaClientes){
//				ArrayList<Aluguel> listaAlugueis = client.getAlugueis();
//				
//				if(!listaAlugueis.isEmpty()){
//					Aluguel alug = listaAlugueis.get(listaAlugueis.size()-1);
//					ultimoAluguel = " Último aluguel: " + Util.formataData(alug.getDatainicio());
//				}
//				else ultimoAluguel = "";
//				
//				stringClientes+=("CPF: " + client.getCpf() + " Nome: " + client.getNome() +  ultimoAluguel + ";" );
//			}
//		}
//		else throw new SystemException("Não existem clientes cadastrados!");
//		
//		return stringClientes;
//	}
//	
//	
//	public static String listarCarros() throws SystemException{
//		String stringCarros = "";
//		ArrayList<Carro> listaCarros = locadora.getCarros();
//		
//		if(!listaCarros.isEmpty()){
//			for(Carro car: listaCarros){
//				ArrayList<Aluguel> listaAlugueis = car.getAlugueis();
//				String nomeCliente = car.isAlugado() ? " Cliente: " + listaAlugueis.get(listaAlugueis.size()-1).getCliente().getNome() : "";
//				stringCarros+="Placa:" + car.getPlaca() + " Modelo:" + car.getModelo() + nomeCliente + ";";
//			}
//		}
//		else throw new SystemException("Não existem carros cadastrados!");
//		
//		return stringCarros;
//	}
//	
//	public static String listarAlugueisFinalizados() throws SystemException{
//		String stringAlugueis = "";
//		ArrayList<Aluguel> listaAlugueis = locadora.getAlugueis();
//		int days = 0;
//		
//		if(!listaAlugueis.isEmpty()){
//			for(Aluguel alug: listaAlugueis){
//				if(alug.isFinalizado()){
//					String dataInit = Util.formataData(alug.getDatainicio());
//					String dataFim = Util.formataData(alug.getDatafim());
//					
//					days += Integer.parseInt(dataFim.split("/")[0]) - Integer.parseInt(dataInit.split("/")[0]);
//					
//					stringAlugueis+="ID:" + alug.getId() + " Carro:" + alug.getCarro().getPlaca() + " Cliente:" + 
//							alug.getCliente().getNome()  + " Valor:" + alug.getValor() + " Inicio: " + 
//							dataInit + " Fim: "  + dataFim + " Quantidade de dias de todos os alugueis: " + days + ";";
//				}
//			}
//			
//			if(stringAlugueis == "") throw new SystemException("Não existem alugueis finalizados!");
//		}
//		else throw new SystemException("Não exisem alugueis cadastrados!");
//		
//		return stringAlugueis;
//	}
//	
//	public static String listarAlugueisHoje() throws SystemException{
//		String alugueisHoje = "";
//		ArrayList<Aluguel> listaAlugueis = locadora.getAlugueis();
//		Date today = new Date();
//		
//		if(!listaAlugueis.isEmpty()){
//			for(Aluguel alug: listaAlugueis){
//				Date fim = alug.getDatafim();
//				
//				if( Util.formataDataDia(today).equals(Util.formataDataDia(fim) ) && !alug.isFinalizado()){
//					alugueisHoje+="ID:" + alug.getId() + " Carro: " + alug.getCarro().getPlaca() + " Cliente:" + 
//							alug.getCliente().getNome();
//				}
//			}
//			
//			if(alugueisHoje.equals("")) 
//				throw new SystemException("Não existem alugueis a serem finalizados hoje!");
//			
//		}else throw new SystemException("Não existem alugueis cadastrados!");
//		
//		return alugueisHoje;
//	}
	


}

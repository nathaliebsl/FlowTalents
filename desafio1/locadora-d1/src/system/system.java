package system;

import model.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
	

	public static Locacao locarVeiculo(String celular, String placa, Date datainicio, Date datafinal) throws Exception{
		
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
							
							
							if(Utilities.validarMotorista(client, vehicle)) {
								
								//comparativo entre cnh do cliente e cat do veiculo
									
							if(!vehicle.isLocado()) { 
								int id = locadora.getLocacoes().size();
								result =  new Locacao(id, datainicio, datafinal, vehicle, client);
								locadora.addLocacao(result);
	
								vehicle.addLocacao(result);
								client.addLocacao(result);
								vehicle.setLocado(true);
								System.out.println("Efetuada Locação do veículo " + vehicle.toString() + " \n  " + client.toString() + "\n");
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
					
//					Date data = new Date();
					GregorianCalendar calendario = new GregorianCalendar();
					
					ArrayList<Locacao> listLocacoes = vehicle.getLocacoes();
					Locacao loc = listLocacoes.get(listLocacoes.size()-1);
					
//					Date di = loc.getDatainicio();
					Date now = calendario.getTime();
//					Date df = loc.getDatafim();
//					
//					if(df.after(now)) 
					
					
					loc.setFinalizado(true);
					vehicle.setLocado(false);
					System.out.println("ENCERRADO: Locação do veículo " + vehicle.toString() + " @ " + now +  "\n"); //será que puxa os dados do veículo?
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
				
				stringClientes+=("CNH: " + client.getCnh() + " Celular: " + client.getCelular() +  ultimaLocacao + ";\n" );
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
				String idCliente = vehicle.isLocado() ? " Veículo está locado para Cliente: " + listaLocacoes.get(listaLocacoes.size()-1).getCliente().getCelular() : "";
				stringVeiculos+="Placa:" + vehicle.getPlaca() + " Modelo:" + vehicle.getMarca() + idCliente + ";\n";
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
					
					stringLocacoes+=" ID:" + loc.getId() + " Veiculo:" + loc.getVeiculo().getPlaca() + " Cliente:" + 
							loc.getCliente().getCelular()  + " Inicio: " + 
							dataInit + " Fim: "  + dataFim + " Quantidade de dias de todos os alugueis: " + days + ";\n";
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

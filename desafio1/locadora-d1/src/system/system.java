package system;

import model.*;

//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class system {
	
private static Locadora locadora = new Locadora();
	
	public static Cliente cadastrarCliente(String celular, String cnh) throws Exception{
		
		Cliente client = null;
		
		if(Utilities.validarCnh(cnh))
		{
			if(Utilities.validarCelular(celular))
			{

				if(!locadora.clienteCadastrado(celular)) {
			
					client = new Cliente(celular, cnh);
					locadora.addCliente(client);
					
				} 
				else throw new Exception("Cliente já cadastrado!");
			}
			else throw new Exception("Celular Inválido!");
		}
		else throw new Exception("Digite uma classe de CNH válida!");
		
		return client;
	}
	
	public static Cliente getCliente(String celular) throws Exception{
		
		Cliente client = null;
			
		if(Utilities.validarCelular(celular))
			{

				if(locadora.clienteCadastrado(celular)) {
			
					client = locadora.localizarCliente(celular);
				} 
				else throw new Exception("Cliente não cadastrado!");
			}
			else throw new Exception("Celular Inválido!");
		
		return client;

	}
	
		
	public static Carro cadastrarCarro(String placa, String marca, int anoFabricacao, String cor, int portas, String ac, String cambio, String direcao) throws Exception{
		
		Carro car = null;
		
		if(Utilities.validarPlaca(placa)){
			
			if(!locadora.veiculoCadastrado(placa)) {
				
				car = new Carro(placa, marca, anoFabricacao, cor, portas, ac, cambio, direcao);
				locadora.addVeiculo(car);
			
			}
			else throw new Exception("Veiculo já cadastrado!");
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return car;
	}
	
	
	public static Moto cadastrarMoto(String placa, String marca, int anoFabricacao, String cor, int cilindradas) throws Exception{
		
		Moto bike = null;
		
		if(Utilities.validarPlaca(placa)){
			
			if(!locadora.veiculoCadastrado(placa)) {
				
				bike = new Moto(placa, marca, anoFabricacao, cor, cilindradas);
				locadora.addVeiculo(bike);
			
			}
			else throw new Exception("Veiculo já cadastrado!");
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return bike;
	}
	
	
	public static Onibus cadastrarOnibus(String placa, String marca, int anoFabricacao, String cor, int assentos) throws Exception{
		
		Onibus bus = null;
		
		if(Utilities.validarPlaca(placa)){
			if(!locadora.veiculoCadastrado(placa)) {
				
				bus = new Onibus(placa, marca, anoFabricacao, cor, assentos);
				locadora.addVeiculo(bus);
			
			}
			else throw new Exception("Veiculo já cadastrado!");
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return bus;
	}
	
	
	public static Caminhao cadastrarCaminhao(String placa, String marca, int anoFabricacao, String cor, int capacidade) throws Exception{
		
		Caminhao truck = null;
		
		if(Utilities.validarPlaca(placa)){
			if(!locadora.veiculoCadastrado(placa)) {
				
				truck = new Caminhao(placa, marca, anoFabricacao, cor, capacidade);
				locadora.addVeiculo(truck);
			
			}
			else throw new Exception("Veiculo já cadastrado!");
		}
		else throw new Exception("Informe uma placa válida - formato AAA####");
		
		return truck;
	}
	
	public static Veiculo getVeiculo(String placa) throws Exception{
		
		Veiculo vehicle = null;
			
		if(Utilities.validarPlaca(placa))
			{

				if(locadora.veiculoCadastrado(placa)) {
			
					vehicle = locadora.localizarVeiculo(placa);
				} 
				else throw new Exception("Veículo não cadastrado!");
			}
			else throw new Exception("Celular Inválido!");
		
		return vehicle;

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
				
				
					if(Utilities.validarPlaca(placa))
					{
						Veiculo vehicle = null;
						
						try{
							vehicle = locadora.localizarVeiculo(placa);
							
							
							if(Utilities.validarMotorista(client, vehicle))
							{
								
									
								if(!vehicle.isLocado())
								{ 
									int id = locadora.getLocacoes().size();
									result =  new Locacao(id, datainicio, datafinal, vehicle, client);
									locadora.addLocacao(result);
	
									vehicle.addLocacao(result);
									client.addLocacao(result);
									vehicle.setLocado(true);
									System.out.println("\nEfetuada Locação do veículo " + vehicle.toString() + " \n  " + client.toString() + "\n");
								}
								else throw new Exception("\nVeículo está alugado\n");
							} 
							else throw new Exception("\nCnh do Motorista não Compativel com Categoria do Veículo\n");
						}
						catch (Exception e){
							System.out.println(e.getMessage());
						}
						
					}else throw new Exception("\nPlaca Inválida!\n");
					
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
					
			}else throw new Exception("\nCelular Inválido!\n");
		}else throw new Exception("\nData final menor que inicial!\n");
		
		return result;
	}
	
	
	public static void encerrarLocacao(String placa) throws Exception{
		
		if(Utilities.validarPlaca(placa)){
			
			Veiculo vehicle = null;
			
			try{
				
				vehicle = locadora.localizarVeiculo(placa);
				
				if(vehicle.isLocado())
				{
					
					GregorianCalendar calendario = new GregorianCalendar();
					
					ArrayList<Locacao> listLocacoes = vehicle.getLocacoes();
					Locacao loc = listLocacoes.get(listLocacoes.size()-1);
					

					Date now = calendario.getTime();
					
					loc.setDatafim(now);
					loc.setFinalizado(true);
					vehicle.setLocado(false);
					System.out.println("\nENCERRADO: Locação do veículo " + vehicle.toString() + " @ " + loc.getDatafim() +  "\n"); //será que puxa os dados do veículo?
				}
				else throw new Exception("\nNão foi possível encerrar. Este Veículo não está locado!\n");
			
			}
			catch (Exception e){
				throw new Exception(e.getMessage());
			}
			
		}else throw new Exception("\nPlaca inválida!\n");
		
		
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
				
				stringClientes+=("Cliente [ID=" + client.getId() + " CNH: " + client.getCnh() + " Celular: " + client.getCelular() +  ultimaLocacao + "];\n" );
			}
		}
		else throw new Exception("\nNão existem clientes cadastrados!\n");
		
		return stringClientes;
	}
	
	
	public static String listarVeiculos() throws Exception{
		String stringVeiculos = "";
		ArrayList<Veiculo> listaVeiculos = locadora.getVeiculos();
		
		if(!listaVeiculos.isEmpty()){
			for(Veiculo vehicle: listaVeiculos){
				ArrayList<Locacao> listaLocacoes = vehicle.getLocacoes();
				String idCliente = vehicle.isLocado() ? " Veículo está locado para Cliente: " + listaLocacoes.get(listaLocacoes.size()-1).getCliente().getCelular() : "";
				stringVeiculos+= vehicle.toString() + idCliente + "];\n";
			}
		}
		else throw new Exception("\nNão existem veículos cadastrados!\n");
		
		return stringVeiculos;
	}
	
	public static String listarLocacoesFinalizadas() throws Exception{
		String stringLocacoes = "";
		ArrayList<Locacao> listaLocacoes = locadora.getLocacoes();
		int days = 0;
		
		if(!listaLocacoes.isEmpty())
		{
			for(Locacao loc: listaLocacoes)
			{
				if(loc.isFinalizado())
				{
					String dataInit = Utilities.formataData(loc.getDatainicio());
					String dataFim = Utilities.formataData(loc.getDatafim());
					
					days += Integer.parseInt(dataFim.split("/")[0]) - Integer.parseInt(dataInit.split("/")[0]);
					
					stringLocacoes+="ID:" + loc.getId() + " Veiculo:" + loc.getVeiculo().getPlaca() + " Cliente:" + 
							loc.getCliente().getCelular()  + " Inicio: " + 
							dataInit + " Finalizado em: "  + dataFim + ";\n";
				}
			}
			
			if(stringLocacoes == "") throw new Exception("\nNão existem locacoes finalizadas\n");
		}
		else throw new Exception("\nNão exisem locacoes cadastradas!\n");
		
		return stringLocacoes;
	}
	
	public static String listarLocacoesHoje() throws Exception{
		String locacoesHoje = "";
		ArrayList<Locacao> listaLocacoes = locadora.getLocacoes();
		Date today = new Date();
		
		if(!listaLocacoes.isEmpty())
		{
			for(Locacao loc: listaLocacoes)
			{
				Date fim = loc.getDatafim();
				
				if(Utilities.formataDataDia(today).equals(Utilities.formataDataDia(fim) ) && !loc.isFinalizado())
				{
					locacoesHoje+= loc.toString() + "\n";
					loc.setDatafim(today);
					loc.setFinalizado(true);
					System.out.println("\nLocações que venciam hoje foram encerradas!\n");
				}
			} 
		
	}
		return locacoesHoje;
	}
	
	
	public static String listarLocacoes() throws Exception{
		String totalLocacoes = "";
		ArrayList<Locacao> listaLocacoes = locadora.getLocacoes();
		
		if(!listaLocacoes.isEmpty()){
			for(Locacao loc: listaLocacoes){
					if(!loc.isFinalizado()) {

					totalLocacoes+= loc.toString() + "\n";
					} else throw new Exception("\nNão existem locações em andamento!\n");
				}
				
			}
			else throw new Exception("\nNão existem locações cadastradas!\n");
		
		return totalLocacoes;
	}


}

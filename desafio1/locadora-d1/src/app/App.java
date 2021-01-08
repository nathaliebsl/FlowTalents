package app;


import java.util.GregorianCalendar;
import java.util.Scanner;

import system.*;
import model.*;


public class App {

	public static void main(String[] args) throws Exception{
		
			Scanner sc = new Scanner(System.in);
			
			int opt = 1;
			
			while(opt != 0){
				menuInicial();
				opt = sc.nextInt();
				
				switch(opt){
				
				case 1:
					opcao01();
					break;
				case 2:
					opcao02();
					break;
				case 3:
					opcao03();
					break;
				case 4:
					opcao04();
					break;
				case 5:
					opcao05();
					break;
				case 6:
					opcao06();
					break;
				case 7:
					opcao07();
					break;
				case 8:
					opcao08();
					break;
				case 9:
					opcao09();
					break;
				}
				
			} sc.close();
			
		}
		
		public static void menuInicial(){
			
			System.out.println("0. Sair");
			System.out.println("1. Cadastrar veiculo");
			System.out.println("2. Cadastrar cliente");
			System.out.println("3. Nova Locação");
			System.out.println("4. Devolução");
			System.out.println("5. Listar clientes");
			System.out.println("6. Listar veiculos");
			System.out.println("7. Listar locações em andamento");
			System.out.println("8. Listar locações finalizadas"); //será que precisa?
			System.out.println("9. Locações a serem finalizados hoje"); // será que precisa? da pra tentar forçar finalizacao automatica daqui?
			
		}
		
		public static void opcao01(){
			
			Scanner sc = new Scanner(System.in);
			String placa, marca, ano, cor, portas, ac, cambio, direcao, cilindradas, capacidade, assentos;
			
			System.out.print("\nCADASTRO DE VEICULOS \n");
			System.out.print("Placa (AAA####):  ");
			placa = sc.next();
			System.out.print("Fabricante:  ");
			marca = sc.next();
			System.out.print("Ano de fabricação (YYYY):  ");
			ano = sc.next();
			System.out.print("Cor:  ");
			cor = sc.next();
			
			int anoFabricacao = Integer.parseInt(ano);
			
			System.out.print("Tipo de veículo (Moto, Carro, Caminhao ou Onibus):  ");
			
			while(sc.hasNext()) 
			{ String tipo = sc.next();

				if(tipo.equalsIgnoreCase("MOTO"))
				{

					System.out.println("Cilindradas (####):  ") ;
					cilindradas = sc.next();
				
					int ccMoto = Integer.parseInt(cilindradas);
				
					try{
						Veiculo vehicle = system.cadastrarMoto(placa, marca, anoFabricacao, cor, ccMoto);
						System.out.println("Cadastro da " + vehicle.toString() + " realizado com Sucesso! \n\n ");
					}
					catch (Exception e){
					System.out.println(e.getMessage()+ "\n");
					}
					return;
				} 
			
				if(tipo.equalsIgnoreCase("CARRO")) 
				{
				
					System.out.println("Numero de portas (##):  ");
					portas = sc.next();
					System.out.println("Ar Condicionado (S ou N):  ");
					ac = sc.next();
					System.out.println("Tipo de Câmbio\n[manual digite: M]\n[automático digite: A]:  ");
					cambio = sc.next();
					System.out.println("Tipo de Direção\n[manual digite: M]\n[hidráulica digite: H]\n[elétrica digite: E]:  ");
					direcao = sc.next();
				
					int doors = Integer.parseInt(portas);
				
					try{
					
						Veiculo vehicle = system.cadastrarCarro(placa, marca, anoFabricacao, cor, doors, ac, cambio, direcao); 
						System.out.println("Cadastro do " + vehicle.toString() + " realizado com Sucesso! \n\n");
					}
					catch (Exception e){
					System.out.println(e.getMessage()+ "\n");
					}
					return;
				}
			
				if(tipo.equalsIgnoreCase("CAMINHAO")) 
				{
				
					System.out.println("Capacidade(em toneladas) (####):  ");
					capacidade = sc.next();
				
					int capacity = Integer.parseInt(capacidade);
				
					try{
					
						Veiculo vehicle = system.cadastrarCaminhao(placa, marca, anoFabricacao, cor, capacity); 
						System.out.println("Cadastro do " + vehicle.toString() + " realizado com Sucesso! \n\n");
					}
					catch (Exception e){
					System.out.println(e.getMessage()+ "\n");
					}
					return;
				
				} 
			
				if(tipo.equalsIgnoreCase("ONIBUS")) 
				{
			
					System.out.println("Quantidade de assentos (###):  ");
					assentos = sc.next();
				
					int seats = Integer.parseInt(assentos);
				
					try{
					
					Veiculo vehicle = system.cadastrarOnibus(placa, marca, anoFabricacao, cor, seats); 
					System.out.println("Cadastro do " + vehicle.toString() + " realizado com Sucesso! \n\n ");
					}
					catch (Exception e){
					System.out.println(e.getMessage()+ "\n");
					}
					return;
				} break;
			} 
			
		}
		
		public static void opcao02(){
			
			Scanner sc = new Scanner(System.in);
			String celular, cnh;
			
			System.out.print("\nCADASTRO DE CLIENTES\n\n");
			System.out.print("Celular do Cliente (DDNNNNNNNNN): ");
			celular = sc.next();
			System.out.print("\nTipo de CNH\n\n[Motos - digite: A]\n[Carros - digite: B]\n[Caminhões e Carros digite: C]\n[Onibus, Caminhões e Carros digite: D]\n");
			cnh = sc.next();
				
				try{
					Cliente client = system.cadastrarCliente(celular, cnh);	
					System.out.println("\nCadastro do " + client.toString() + " realizado com Sucesso! \n\n ");
				}
				catch (Exception e){
					System.out.println("\n" + e.getMessage() + "\n");
			
				}
			return;				
		}
			
		
		public static void opcao03() {
			Scanner sc = new Scanner(System.in);
			String celular, placa, di, df, hi, hf;
			
			System.out.print("\nNOVA LOCAÇÃO\n");
			System.out.print("Celular (DDNNNNNNNNN):  ");
			celular = sc.next();
			System.out.print("Placa do veículo (AAANNNN):  ");
			placa = sc.next();
			System.out.print("Data de início (dd/MM/yyyy):  ");
			di = sc.next();
			System.out.print("Hora de inicio (HH:mm:ss):  ");
			hi = sc.next();
			System.out.print("Data da devolução (dd/MM/yyyy):  ");
			df = sc.next();
			System.out.print("Hora da devolução (HH:mm:ss):  ");
			hf = sc.next();
			
			String[] dataInit  = di.split("/");
			String[] dataFinal = df.split("/");
			String[] horaInit  = hi.split(":");
			String[] horaFinal = hf.split(":");
			
			//colocar mais um if para data inicial nao ser anterior a hoje e nem a data final
			if((dataInit.length + horaInit.length == 6) && ( dataFinal.length + horaFinal.length == 6))
			{
				GregorianCalendar calendarInit = new GregorianCalendar(Integer.parseInt(dataInit[2]), Integer.parseInt(dataInit[1])-1, 
						Integer.parseInt(dataInit[0]), Integer.parseInt(horaInit[0]), Integer.parseInt(horaInit[1]));
				GregorianCalendar calendarFinal = new GregorianCalendar(Integer.parseInt(dataFinal[2]), Integer.parseInt(dataFinal[1])-1, 
						Integer.parseInt(dataFinal[0]), Integer.parseInt(horaFinal[0]), Integer.parseInt(horaFinal[1]));
				
				GregorianCalendar today = new GregorianCalendar();
				
				if(!(calendarInit.getTime().compareTo(today.getTime()) < 0) && !(calendarFinal.getTime().compareTo(today.getTime()) < 0) && !(calendarFinal.getTime().compareTo(calendarInit.getTime()) < 0)) 
				{
					
					try{
					Locacao loc = system.locarVeiculo(celular, placa, calendarInit.getTime(), calendarFinal.getTime());
					System.out.println("\nData da devolução: " + loc.getDatafim() + "\n\n");
					}
					catch (Exception e){
					System.out.println(e.getMessage() + "\n");
					}
				} else { 
					System.out.println("Favor informar datas válidas");
				}
			}
			
		}
		
		public static void opcao04(){
			Scanner sc = new Scanner(System.in);
			String placa;
			
			System.out.print("\nDEVOLUÇÃO\n");
			System.out.print("Placa do veículo (AAANNNN):  ");
			placa = sc.next();
			
			try{
				system.encerrarLocacao(placa);
				System.out.println("Veículo devolvido com sucesso!");
			}
			catch (Exception e){
				System.out.println(e.getMessage() + "\n");
			}
			
			
		}
		
		public static void opcao05(){
			System.out.println("\nCATÁLOGO DE CLIENTES:\n");
			try{
				String lista = system.listarClientes();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		public static void opcao06(){
			System.out.println("\nCATÁLOGO DE VEÍCULOS:\n");
			try{
				String lista = system.listarVeiculos();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		public static void opcao07(){
			System.out.println("\nLOCAÇÕES EM ANDAMENTO:\n");
			try{
				String lista = system.listarLocacoes();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		public static void opcao08(){
			System.out.println("\nLOCAÇÕES FINALIZADAS:\n");
			try{
				String lista = system.listarLocacoesFinalizadas();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		//será que consigo enviar isso para que cada vez que o menu carregar ele acione?
		public static void opcao09(){
			System.out.println("\nLOCAÇÕES VENCENDO HOJE:\n");
			try{
				String lista = system.listarLocacoesHoje();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		
}



package app;


import java.util.GregorianCalendar;
import java.util.Scanner;

import system.*;
import model.*;


public class App {

	public static void main(String[] args) throws Exception{
		
			Scanner sc = new Scanner(System.in);
			
			//Cadastro prévio de clientes e carros
			
			//flow00();
			
			int op = 1;
			
			while(op != 0){
				showMenu();
				op = sc.nextInt();
				
				switch(op){
				
				case 1:
					chain01();
					break;
				case 2:
					chain02();
					break;
				case 3:
					chain03();
					break;
				case 4:
					chain04();
					break;
				case 5:
					chain05();
					break;
				case 6:
					chain06();
					break;
				case 7:
					chain07();
					break;
				case 8:
					chain08();
					break;
				}
				
			}
			
		}
		
		public static void showMenu(){
			
			System.out.println("0. Sair");
			System.out.println("1. Cadastrar veiculo");
			System.out.println("2. Cadastrar cliente");
			System.out.println("3. Nova Locação");
			System.out.println("4. Devolução");
			System.out.println("5. Listar clientes");
			System.out.println("6. Listar veiculos");
			System.out.println("7. Listar locações finalizadas"); //será que precisa?
			System.out.println("8. Listar locações a serem finalizados hoje"); // será que precisa? da pra tentar forçar finalizacao automatica daqui?
			
		}
		
		public static void chain01(){
			
			Scanner cs = new Scanner(System.in);
			String placa, marca, ano, cor, categoria, portas, ac, cambio, direcao, cilindradas, capacidade, assentos;
			
			System.out.print("Placa (AAA####): ");
			placa = cs.next();
			System.out.print("Marca: ");
			marca = cs.next();
			System.out.print("Ano de fabricação (YYYY): ");
			ano = cs.next();
			System.out.print("Cor: ");
			cor = cs.next();
			System.out.print("Classe do veículo - A(Moto), B(Carro), C(Caminhão) ou D(Onibus): ");
			categoria = cs.next();
			
			int anoFabricacao = Integer.parseInt(ano);
			
			
			if(categoria == "A") {
				
				System.out.println("Cilindradas (####): ") ;
				cilindradas = cs.next();
				int ccMoto = Integer.parseInt(cilindradas);
				
				try{
					
					Veiculo vehicle = system.cadastrarMoto(placa, marca, anoFabricacao, cor, ccMoto);
					System.out.println("Cadastro de " + vehicle.toString() + "realizado com Sucesso! ");
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			
			if(categoria == "B") {
				
				System.out.println("Portas (##): ");
				portas = cs.next();
				System.out.println("AC (S ou N): ");
				ac = cs.next();
				System.out.println("Cambio (M ou A): ");
				cambio = cs.next();
				System.out.println("Direção (M, H ou E): ");
				direcao = cs.next();
				
				int doors = Integer.parseInt(portas);
				
				try{
					
					Veiculo vehicle = system.cadastrarCarro(placa, marca, anoFabricacao, cor, doors, ac, cambio, direcao); 
					System.out.println("Cadastro de " + vehicle.toString() + "realizado com Sucesso! \n\n");
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
				
				
			}
			
			if(categoria == "C") {
				
				System.out.println("Capacidade(em toneladas) (####) : ");
				capacidade = cs.next();
				
				int capacity = Integer.parseInt(capacidade);
				
				try{
					
					Veiculo vehicle = system.cadastrarCaminhao(placa, marca, anoFabricacao, cor, capacity); 
					System.out.println("Cadastro de " + vehicle.toString() + "realizado com Sucesso! \n\n");
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			
			if(categoria == "D") {
			
				System.out.println("Quantidade de assentos (###) : ");
				assentos = cs.next();
				
				int seats = Integer.parseInt(assentos);
				
				try{
					
					Veiculo vehicle = system.cadastrarOnibus(placa, marca, anoFabricacao, cor, seats); 
					System.out.println("Cadastro de " + vehicle.toString() + "realizado com Sucesso! ");
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
			

		}
		
		public static void chain02(){
			
			Scanner cs = new Scanner(System.in);
			String celular, cnh;
			
			System.out.print("Celular do Cliente (DDNNNNNNNNN) : ");
			celular = cs.next();
			System.out.print("Tipo de CNH (A, B, C, D) : ");
			cnh = cs.next();
				
				try{
					Cliente client = system.cadastrarCliente(celular, cnh);	
					System.out.println("Cadastro de " + client.toString() + " realizado com Sucesso! \n\n ");
				}
				catch (Exception e){
					System.out.println(e.getMessage() + "\n");
				}
							
		}
			
		
		public static void chain03(){
			Scanner cs = new Scanner(System.in);
			String celular, placa, di, df, hi, hf;
			
			System.out.print("Celular (DDNNNNNNNNN): ");
			celular = cs.next();
			System.out.print("Placa do carro (AAANNNN): ");
			placa = cs.next();
			System.out.print("Data início (dd/MM/yyyy): ");
			di = cs.next();
			System.out.print("Hora inicio (HH:mm:ss): ");
			hi = cs.next();
			System.out.print("Data fim (dd/MM/yyyy): ");
			df = cs.next();
			System.out.print("Hora fim (HH:mm:ss): ");
			hf = cs.next();
			
			String[] dataInit  = di.split("/");
			String[] dataFinal = df.split("/");
			String[] horaInit  = hi.split(":");
			String[] horaFinal = hf.split(":");
			
			if((dataInit.length + horaInit.length == 6) && ( dataFinal.length + horaFinal.length == 6)){
				GregorianCalendar calendarInit = new GregorianCalendar(Integer.parseInt(dataInit[2]), Integer.parseInt(dataInit[1])-1, 
						Integer.parseInt(dataInit[0]), Integer.parseInt(horaInit[0]), Integer.parseInt(horaInit[1]));
				GregorianCalendar calendarFinal = new GregorianCalendar(Integer.parseInt(dataFinal[2]), Integer.parseInt(dataFinal[1])-1, 
						Integer.parseInt(dataFinal[0]), Integer.parseInt(horaFinal[0]), Integer.parseInt(horaFinal[1]));

				try{
					Locacao loc = system.locarVeiculo(celular, placa, calendarInit.getTime(), calendarFinal.getTime());
					System.out.println("Aluguel realizado com sucesso!\n Data de devolução: " + loc.getDatafim());
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
			

			
		}
		
		public static void chain04(){
			Scanner cs = new Scanner(System.in);
			String placa;
			
			System.out.print("Placa do carro (AAANNNN): ");
			placa = cs.next();
			
			try{
				system.encerrarLocacao(placa);
				System.out.println("Carro devolvido com sucesso!");
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		
		public static void chain05(){
			try{
				String lista = system.listarClientes();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		public static void chain06(){
			try{
				String lista = system.listarVeiculos();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		public static void chain07(){
			try{
				String lista = system.listarLocacoesFinalizadas();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		public static void chain08(){
			try{
				String lista = system.listarLocacoesHoje();
				String[] array = lista.split(";");
				
				for(String str: array){
					System.out.println(str);
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		
}



package app;


import java.util.GregorianCalendar;
import java.util.Scanner;

import system.*;
import model.*;


public class App {

	public static void main(String[] args) throws Exception{
		
			Scanner sc = new Scanner(System.in);
			
			//Cadastro prévio de clientes e carros
			flow00();
			
			int op = 1;
			
			while(op != 0){
				showMenu();
				op = sc.nextInt();
				
				switch(op){
				case 1:
					flow01();
					break;
				case 2:
					flow02();
					break;
				case 3:
					flow03();
					break;
				case 4:
					flow04();
					break;
				case 5:
					flow05();
					break;
				case 6:
					flow06();
					break;
				}
				
			}
			
		}
		
		public static void showMenu(){
			
			System.out.println("0. Sair");
			System.out.println("1. Alugar carro");
			System.out.println("2. Devolver carro");
			System.out.println("3. Listar clientes");
			System.out.println("4. Listar carros");
			System.out.println("5. Listar alugueis finalizados");
			System.out.println("6. Listar alugueis a serem finalizados hoje");
			
		}
		
		public static void flow00(){
			try{
				system.cadastrarCliente("99999999999", "B");
				system.cadastrarCliente("88888888888", "A");
				system.cadastrarCliente("77777777777", "D");
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			try{
				system.cadastrarCarro("CCC1111", "honda", 2021, "branco", 4, 'S', 'A', "eletrica");
				system.cadastrarMoto("MMM1111", "honda", 2021, "preto", 100);
				system.cadastrarOnibus("OOO1111", "honda", 2021, "verde", 100);
				system.cadastrarCaminhao("TTT1111", "honda", 2021, "roxo", 2000);
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		public static void flow01(){
			Scanner cs = new Scanner(System.in);
			String celular, placa, di, df, hi, hf;
			
			System.out.print("Celular (ddnnnnnnnnn): ");
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
		
		public static void flow02(){
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
		
		public static void flow03(){
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
		
		public static void flow04(){
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
		
		public static void flow05(){
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
		
		public static void flow06(){
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



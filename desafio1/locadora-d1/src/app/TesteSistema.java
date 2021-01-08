package app;

import java.util.GregorianCalendar;

import model.Utilities;

import java.text.SimpleDateFormat;

import system.*;


public class TesteSistema {
	
	public static void main(String args[]){
		try{
			system.cadastrarMoto("MMM1111", "honda", 2020, "verde", 100);
			system.cadastrarCarro("CCC1111", "honda", 2021, "preto", 4, "S", "A", "H");
			system.cadastrarCaminhao("TTT1111", "volvo" ,2010, "preto", 5000);
			system.cadastrarOnibus("OOO1111", "volvo" ,2010, "branco", 100);
			
			
			try{
				
				system.cadastrarCliente("99999999999", "D");
				system.cadastrarCliente("88888888888", "A");
				system.cadastrarCliente("55555555555", "C");
				system.cadastrarCliente("44444444444", "B");
				System.out.println(system.listarClientes());
				system.getCliente("99999999999").setCelular("77777777777");
				System.out.println(system.getCliente("77777777777"));
				system.getCliente("77777777777").addCnh("B");
				system.getCliente("77777777777").addCnh("C");
				System.out.println(system.getCliente("77777777777"));
				
				System.out.println(Utilities.validarMotorista(system.getCliente("77777777777"), system.getVeiculo("OOO1111")));
				System.out.println(Utilities.validarMotorista(system.getCliente("88888888888"), system.getVeiculo("MMM1111")));
				System.out.println(Utilities.validarMotorista(system.getCliente("55555555555"), system.getVeiculo("TTT1111")));
				System.out.println(Utilities.validarMotorista(system.getCliente("44444444444"), system.getVeiculo("CCC1111")));
				
				System.out.println(system.getCliente("88888888888").getCnh().contains(system.getVeiculo("MMM1111").getCategoria()));
				System.out.println(system.getCliente("77777777777").getCnh().contains(system.getVeiculo("CCC1111").getCategoria()));
//				System.out.println(system.getCliente("44444444444").getCnh().contains(system.getVeiculo("CCC1111").getCategoria()));
				System.out.println(system.getCliente("44444444444").getCnh());
				System.out.println(system.getVeiculo("CCC1111").getCategoria());
				System.out.println(system.getCliente("77777777777").getCnh());

				
				try{
					
					GregorianCalendar calendario = new GregorianCalendar();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					system.locarVeiculo("44444444444", "CCC1111", calendario.getTime(), format.parse("2022-01-30 15:00"));
					system.locarVeiculo("88888888888", "MMM1111", calendario.getTime(), format.parse("2022-01-14 12:00"));
					system.encerrarLocacao("CCC1111");
					system.encerrarLocacao("MMM1111");
					String loc = system.listarLocacoesFinalizadas();
					System.out.println("Locações Finalizadas= " + loc);
					system.locarVeiculo("77777777777", "OOO1111", calendario.getTime(), format.parse("2022-01-14 12:00"));
					loc = system.listarClientes();
					System.out.println(loc);
					loc = system.listarVeiculos();
					System.out.println(loc);
					loc = system.listarLocacoesHoje();
					System.out.println("Finalizar Hoje: " + loc);
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	

}

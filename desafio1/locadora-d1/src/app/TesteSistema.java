package app;


//import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

//import model.*;
import system.*;


public class TesteSistema {
	
	public static void main(String args[]){
		try{
			system.cadastrarCarro("CCC1111", "honda", 2020, "verde", 4, 'S', 'A', "eletrica");
			system.cadastrarCarro("CCC2222", "honda", 2021, "preto", 4, 'S', 'A', "eletrica");
			
			try{
				
				system.cadastrarCliente("99999999999", "B");
				system.cadastrarCliente("88888888888", "B");
				//System.out.println("Cadastro realizado!");
				
				try{
					
					GregorianCalendar calendario = new GregorianCalendar();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					system.locarVeiculo(calendario.getTime(), format.parse("2022-01-30 15:00"), "99999999999", "CCC1111");
					system.locarVeiculo(calendario.getTime(), format.parse("2022-01-14 12:00"),  "88888888888", "CCC2222");
					system.encerrarLocacao("CCC2222");
					String loc = system.listarLocacoesFinalizadas();
					System.out.println("Finalizados=" + loc);
					system.locarVeiculo(calendario.getTime(), format.parse("2021-01-31 12:00"),  "88888888888", "CCC2222");
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

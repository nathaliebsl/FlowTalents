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
				
				try{
					
					GregorianCalendar calendario = new GregorianCalendar();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					system.locarVeiculo("99999999999", "CCC1111", calendario.getTime(), format.parse("2022-01-30 15:00"));
					system.locarVeiculo("88888888888", "CCC2222", calendario.getTime(), format.parse("2022-01-14 12:00"));
					system.encerrarLocacao("CCC2222");
					system.encerrarLocacao("ccc1111");
					String loc = system.listarLocacoesFinalizadas();
					System.out.println("Locações Finalizadas= " + loc);
					system.locarVeiculo("88888888888", "CCC2222", calendario.getTime(), format.parse("2022-01-14 12:00"));
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

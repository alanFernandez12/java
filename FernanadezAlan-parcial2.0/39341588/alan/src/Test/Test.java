package Test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Dispositivos;
import modelo.Funciones;
import modelo.Metrica;
import modelo.SistemaSaludDispositivos;

public class Test {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("1)");
		SistemaSaludDispositivos s1=new SistemaSaludDispositivos();
		
		s1.agregarEmpresa("Empresa 1");
		s1.agregarEmpresa("Empresa 2");
		System.out.println(s1.getLsEmpresa());
		
		System.out.println("2)");
		System.out.println(s1.traerEmpresa("Empresa 2"));
		
		System.out.println("3)");
		try {
			s1.agregarDispositivo("sensor humedad","A2020",s1.traerEmpresa("Empresa 1"));
			s1.agregarDispositivo("sensor temperatura","A2325",s1.traerEmpresa("Empresa 1"));
			s1.agregarDispositivo("sensor presion","B2021",s1.traerEmpresa("Empresa 2"));
			s1.agregarDispositivo("sensor calor","B2326",s1.traerEmpresa("Empresa 2"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println(s1.getLsDispositivos());
		
		System.out.println("4");
		s1.agregarDispositivo("sensor Movimiento","B2022",s1.traerEmpresa("Empresa 2"));
		
		System.out.println("5)");
		System.out.println(s1.traerDispositivo("B2326"));
		
		System.out.println("6)");
		Dispositivos d1=s1.traerDispositivo("B2326");
		
		d1.agregarMetrica(18,LocalDate.of(2022, 9, 18), LocalTime.of(10, 00));
		d1.agregarMetrica(19,LocalDate.of(2022, 9, 19), LocalTime.of(12, 30));
		d1.agregarMetrica(23,LocalDate.of(2022, 9, 20), LocalTime.of(15, 00));
		d1.agregarMetrica(20,LocalDate.of(2022, 9, 21), LocalTime.of(18, 30));
		d1.agregarMetrica(18,LocalDate.of(2022, 9, 22), LocalTime.of(22, 30));
		System.out.println(d1.getLsMetricas());
		System.out.println("7)");
		System.out.println(d1.traerMetrica(LocalDate.of(2022, 9, 19), LocalTime.of(12, 30)));
		
		
		System.out.println("8");
		System.out.println(d1.traerMetricas(LocalDate.of(2022, 9, 19),LocalDate.of(2022, 9, 21)));
		
		
		
		
		
	}

}

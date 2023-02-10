package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Funciones;

public class Funciones {
	
	public static boolean esBisiesto(int anio)throws Exception {
		if(anio<0)throw new Exception("error: no hay años negativos");
		return (anio%4==0) &&(anio%100!=0) &&(anio%400!=0);
	}
	public static boolean esFechaValida(LocalDate fecha)throws Exception {
		int anio=fecha.getYear();
		int mes=fecha.getMonthValue();
		int dia=fecha.getDayOfMonth();
		boolean bi= Funciones.esBisiesto(anio);
		if(dia==29 && mes==2 && bi==false)throw new Exception("No es una fecha valida");
			
		return true;
		
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		String dia=fecha.getDayOfMonth()+"";
		String mes=fecha.getMonthValue()+"";
		String anio=fecha.getYear()+"";
		
		return dia+"/"+mes+"/"+anio;
		
		}
	public static String traerHoraCorta(LocalTime hora) {
		String horas=hora.getHour()+"";
		String minutos=hora.getMinute()+"";
		return horas+":"+minutos;
	}
	public static boolean esDiaHabil(LocalDate fecha) {
		int dia=fecha.getDayOfWeek().getValue();
		
		return (dia>=1) && (dia<=5);
	}
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String dia="";
		int diaN=fecha.getDayOfWeek().getValue();
		switch(diaN) {
		case 1:{
			dia="Lunes";
			break;
		}
		case 2:{
			dia="Martes";
			break;
		}
		case 3:{
			dia="Miercoles";
			break;
		}
		case 4:{
			dia="Jueves";
			break;
		}
		case 5:{
			dia="Viernes";
			break;
		}
		case 6:{
			dia="Sabado";
			break;
		}
		case 7:{
			dia="Domingo";
			break;
		}
		}
		return dia;
		
	}
	public static String traerMesEnLetras(LocalDate fecha) {

		String mes="";
		int mesNum=fecha.getMonthValue();
		switch(mesNum) {
		case 1: {
			mes= "enero";
			break;
		}
		case 2:{
			mes="febrero";
			break;
		}
		case 3:{
			mes="marzo";
			break;
		}
		case 4:{
			mes="abril";
			break;
		}
		case 5:{
			mes="mayo";
			break;
		}
		case 6:{
			mes="junio";
			break;
		}
		case 7:{
			mes="julio";
			break;
		}
		case 8:{
			mes="agosto";
			break;
		}
		case 9:{
			mes="septiemnbre";
			break;
		}
		case 10:{
			mes="octubre";
			break;
		}
		case 11:{
			mes="noviembre";
			break;
		}
		case 12:{
			mes="diciembre";
			break;
		}
		}
		return mes;
		
	}
	public static String traerFechaLarga(LocalDate fecha) {
		String dia=Funciones.traerDiaDeLaSemana(fecha);
		int numero=fecha.getDayOfMonth();
		String mes=Funciones.traerMesEnLetras(fecha);
		int anio=fecha.getYear();
		return dia+" "+numero+" de "+mes+" del "+anio;
	}
	public static int traerCantDiasDeUnMes(int anio,int mes) throws Exception {
		int diaMes=0;;
		switch(mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:{
			diaMes=31;
			break;
		}
		case 4: case 6: case 9: case 11:{
			diaMes=30;
			break;
		}
		case 2:{
			if(Funciones.esBisiesto(anio)) {
				diaMes=28;
				break;
			}
			else {
				diaMes=29;
				break;
			}
			
		}
		}
		return diaMes;
		
	}
	public static int calcularCantDiasTrabajados(int anio, int mes,boolean habil) throws Exception {
		int cantDiasDelMes=Funciones.traerCantDiasDeUnMes(anio, mes);
		
		int cant=0;
		LocalDate m=null;
		if(habil==true) {
			for(int i=1;i<cantDiasDelMes;i++) {
				 m=LocalDate.of(anio,mes,i);
				if(Funciones.esDiaHabil(m)) {
					cant++;
				}
			}
		}
		else {
			for(int i=1;i<cantDiasDelMes;i++) {
				 m=LocalDate.of(anio,mes,i);
				if(Funciones.esDiaHabil(m)!=true) {
					cant++;
				}
			}
		}
		
		return cant;
	}
		
	
}

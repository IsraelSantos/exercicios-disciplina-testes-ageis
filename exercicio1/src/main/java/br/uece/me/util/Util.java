package br.uece.me.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Util {

	public static boolean dateBefore(Date inicio, Date fim) {
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.setTime(inicio);
		b.setTime(fim);
		return a.before(b);		
	}
	
	public static boolean dateAfter(Date inicio, Date fim) {
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.setTime(inicio);
		b.setTime(fim);
		return a.after(b);		
	}
	
	public static boolean dateEquals(Date inicio, Date fim) {
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.setTime(inicio);
		b.setTime(fim);
		return a.equals(b);		
	}
	
	public static Date setData(Date date, int dia, int mes, int ano, int hora, int minuto) {
		if (!Objects.isNull(date)) {
			Calendar a = Calendar.getInstance();
			a.setTime(date);
			
			int mesTmp = mes-1;
			
			a.set(ano, (mesTmp > 0)? mesTmp:0 , dia, hora, minuto);
			
			date.setTime(a.getTimeInMillis());
		}
		return date;
	}
	
}

package les21.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Date date = new Date();
		
		LocalDate ld = toLocalDate(date);
		LocalTime lt = toLocalTime(date);
		LocalDateTime ldt = toLocalDateTime(date);

		System.out.println("Date format: "+date);
		System.out.println("LocalDate format: "+ld);
		System.out.println("LocalTime format: "+lt);
		System.out.println("LocalDateTime format: "+ldt);
		
	}

	public static LocalDate toLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalTime toLocalTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public static LocalDateTime toLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}

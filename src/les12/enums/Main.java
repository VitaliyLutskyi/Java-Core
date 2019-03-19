package les12.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/** Used for reading data from console*/
		Scanner s = new Scanner(System.in);
		

		List<Month> months = new ArrayList<Month>(12);
		months.add(new Month("January", 31, Seasons.WINTER));
		months.add(new Month("February", 28, Seasons.WINTER));
		months.add(new Month("March", 31, Seasons.SPRING));
		months.add(new Month("April", 30, Seasons.SPRING));
		months.add(new Month("May", 31, Seasons.SPRING));
		months.add(new Month("June", 30, Seasons.SUMMER));
		months.add(new Month("July", 31, Seasons.SUMMER));
		months.add(new Month("August", 31, Seasons.SUMMER));
		months.add(new Month("September", 30, Seasons.AUTUMN));
		months.add(new Month("October", 31, Seasons.AUTUMN));
		months.add(new Month("November", 30, Seasons.AUTUMN));
		months.add(new Month("December", 31, Seasons.WINTER));
	
		System.out.println(months);
		/* Eternal loop*/
		while(true) {
			System.out.println("Ââåä³òü ì³ñÿöü:");
					
			String month = s.next();
			
			//Checking for existing the month
			boolean flag = false;
			for(Month m: months) {
				if (m.getMonth().equalsIgnoreCase(month)) {
					flag = true;
					System.out.println("\nThe month exists.");
				}				
			}
			if (!flag) {
				System.out.println("\nThe month doesn't exist.");	
				return;
			}
			
			// Searching the season and days number of inputted month
			Seasons season = null;
			int days = 0;
			int monthsNumber = 0;
			for(int i=0;i<months.size();i++) {
				if(months.get(i).getMonth().equalsIgnoreCase(month)) {
					season=months.get(i).getSeason();
					days=months.get(i).getDays();
					monthsNumber = i;
					break;
				}
			}
			
			//Printing the  months with the same season
			System.out.println("\nMonths with the same season:");
			
			for(Month m: months) {
				if(m.getSeason().equals(season) && !m.getMonth().equalsIgnoreCase(month)) 
					System.out.println(m.getMonth());		
			}
			
			//Printing the months with the same numbers of days
			System.out.println("\nMonths with the same days count:");
			flag = false;
			
			for(Month m: months) {
				if(m.getDays() == days && !m.getMonth().equalsIgnoreCase(month)) {
					System.out.println(m.getMonth());
					flag = true;
				}	
			}
			if(!flag)
					System.out.println("There are no months with the same days count.");
			
			//Printing the months with less numbers of days
			System.out.println("\nMonths with less days count:");
			flag = false;
			for(Month m: months) {
				if(m.getDays() < days) {
					System.out.println(m.getMonth());
					flag = true;
				}
			}
			if(!flag)
				System.out.println("There are no months with less days count.");
			
			//Printing the months with bigger numbers of days
			System.out.println("\nMonths with more days count:");
			flag = false;
			for(Month m: months) {
				if(m.getDays() > days) {
					System.out.println(m.getMonth());
					flag = true;
				}
			}
			if(!flag)
				System.out.println("There are no months with more days count.");
			
			//Printing the next season
			System.out.println("\nThe next season is:");
			flag = false;
			for(int i=monthsNumber; i<months.size(); i++) {
				if(!months.get(i).getSeason().equals(season)) {
					System.out.println(months.get(i).getSeason().name());
					flag = true;
					break;
				}
				if(i == months.size()-1)
					i=-1;
			}
			
			//Printing the previous season
			System.out.println("\nThe previous season is:");
			flag = false;
			for(int i=monthsNumber; i<months.size(); i--) {
				if(!months.get(i).getSeason().equals(season)) {
					System.out.println(months.get(i).getSeason().name());
					flag = true;
					break;
				}
				if(i == 0)
					i = months.size();
			}
			
			//Printing all the months with even number of days
			System.out.println("\nThe months with even days count:");
			for(Month m: months) {
				if(m.getDays() % 2 == 0) 
					System.out.println(m.getMonth());
			}
			
			//Printing all the months with odd number of days
			System.out.println("\nThe months with odd days count:");
			for(Month m: months) {
				if(m.getDays() % 2 == 1) 
					System.out.println(m.getMonth());
			}
			
			//Printing is the number of days of current month even either odd
			if(months.get(monthsNumber).getDays() % 2 == 0)
				System.out.println("\nThere is even days count in the inputted month.");
			else
				System.out.println("\nThere is odd days count in the inputted month");
		}

	}

}

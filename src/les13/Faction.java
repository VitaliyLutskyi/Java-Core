package les13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Faction {
	
	String name;
	List<Deputy> deputies = new ArrayList<>();
	
	public Faction(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public List<Deputy> getDeputies() {
		return deputies;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeputies(List<Deputy> deputies) {
		this.deputies = deputies;
	}

	@Override
	public String toString() {
		return "Faction [name=" + name + ", deputies=" + deputies + "]";
	}

	public void addDeputy() {
		
		Scanner s = new Scanner(System.in);
		int deputyWeight;
		int deputyHeight;
		String deputyLastName;
		String deputyFirstName;
		int deputyAge;
		boolean isDeputyBribeTaker;
		
		System.out.println("Введіть масу депутата");
		deputyWeight = s.nextInt();
		System.out.println("Введіть висоту депутата");
		deputyHeight = s.nextInt();
		System.out.println("Введіть прізвище депутата");
		deputyLastName = s.next();
		System.out.println("Введіть ім'я депутата");
		deputyFirstName = s.next();
		System.out.println("Введіть вік депутата");
		deputyAge = s.nextInt();
		System.out.println("Введіть чи є депутат хабарником (так або ні)");
		if(s.next().equalsIgnoreCase("так"))
			isDeputyBribeTaker = true;
		else
			isDeputyBribeTaker = false;
		
		deputies.add(new Deputy(deputyWeight, deputyHeight, deputyLastName, deputyFirstName, deputyAge, isDeputyBribeTaker));
	}
	
	public void removeDeputy() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Введіть прізвище депутата якого хочете видалити");
		String deputyLastName = s.next();
		
		boolean flag = false;
		
		Iterator<Deputy> iterator = deputies.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getLastName().equalsIgnoreCase(deputyLastName)) {
				iterator.remove();
				flag = true;
			}
		}
		if(!flag) 
			System.out.println("В даній фракції нема депутата з таким прізвищем.");
	}
	
	public void outputBribeTakers() {
		
		System.out.println("\nХабарники фракції" + name + ":");
		Iterator<Deputy> iterator = deputies.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().isBribeTaker())
				System.out.println(iterator.next());
		}
	}
	
	public void outputBiggestBribeTaker() {
		
		Collections.sort(deputies, new DeputyBribeSizeComparator());
		
		if (!(deputies.get(0).getBribeSize()==deputies.get(1).getBribeSize()))
			System.out.println("Найбільший хабарник: " + deputies.get(0));
		else {
			System.out.print("Найбільші хабарники: ");
			for(Deputy d : deputies) {
				if(d.getBribeSize() == deputies.get(0).getBribeSize())
					System.out.println(d + ", ");
				else
					return;
			}			
		}	
	}
	
	public void outputAllDeputies() {
		
		System.out.println("Депутати фракції: ");
		for(Deputy d : deputies)
			System.out.println(d);
	}
	
	public void clearAll() {
		deputies.clear();
	}
}

































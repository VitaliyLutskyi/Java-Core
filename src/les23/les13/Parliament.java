package les23.les13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Parliament {
	
	private Parliament() {
	}
	
	private static class ParliamentHolder{
		private final static Parliament parliament = new Parliament();
	}
	
	public static Parliament getParliament() {
		return ParliamentHolder.parliament;
	}
	
	List<Faction> factions = new ArrayList<>();
	
	public List<Faction> getFactions() {
		return factions;
	}

	public void addFaction() {
		
		Scanner s = new Scanner(System.in);

			System.out.println("Введіть назву фракції яку хочете додати");
			String factionName = s.next();
			
			if(isFaction(factionName)) 
				System.out.println("Така фракція уже існує");
	
			else {
				factions.add(new Faction(factionName));
				System.out.println("Додано фракцію " + factionName);
			}
			

		
	}
	
	public void removeFaction() {
		
		Scanner s = new Scanner(System.in);
		
			System.out.println("Введіть назву фракції яку хочете видалити");
			String factionName = s.next();
			
			if(!isFaction(factionName)) 
				System.out.println("Такої фракції не існує");
			else {
				factions = factions.stream().filter(f->!(f.getName().equalsIgnoreCase(factionName))).collect(Collectors.toList());
				System.out.println("Фракцію "+ factionName + " видалено");
			}
	}
	
	public void outputAllFactions() {
		
		System.out.println("Є такі фракції:\n");
		factions.stream().forEach(f->System.out.print(f.name+ "\t"));
		System.out.println();
	}
	
	public void addDeputy() {

		Scanner s = new Scanner(System.in);

		System.out.println("Введіть назву фракції до якої хочете додати депутата");
		String factionName = s.next();

		if (!isFaction(factionName))
			System.out.println("Такої фракції не існує");
		else
			factions.stream().filter(f -> f.getName().equalsIgnoreCase(factionName)).findFirst()
					.ifPresent(Faction::addDeputy);
	}

	public void removeDeputy() {

		Scanner s = new Scanner(System.in);

		System.out.println("Введіть назву фракції з якої хочете видалити депутата");
		String factionName = s.next();

		if (!isFaction(factionName))
			System.out.println("Такої фракції не існує");
		else
			factions.stream().filter(f -> f.getName().equalsIgnoreCase(factionName)).findFirst()
					.ifPresent(Faction::removeDeputy);
	}
	
	public void outputFactionBribeTakers() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Введіть назву фракції, хабарників якої хочете вивести");
		String factionName = s.next();
		if(!isFaction(factionName)) 
			System.out.println("Такої фракції не існує");
		else
			factions.stream().filter(f -> f.getName().equalsIgnoreCase(factionName)).findFirst()
			.ifPresent(Faction::outputBribeTakers);
		
	}
		
	public void outputBiggestFactionBribeTaker() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Введіть назву фракції, найбільшого хабарника якої хочете вивести");
		String factionName = s.next();
		if(!isFaction(factionName)) 
			System.out.println("Такої фракції не існує");
		else
			factions.stream().filter(f -> f.getName().equalsIgnoreCase(factionName)).findFirst()
			.ifPresent(Faction::outputBiggestBribeTaker);
		
	}
	
	public void outputFactionDeputies() {
		
		Scanner s = new Scanner(System.in);
		
			System.out.println("Введіть назву фракції, депутатів якої хочете вивести:");
			String factionName = s.next();
			if(!isFaction(factionName)) 
				System.out.println("Такої фракції не існує");
			else
				factions.stream().filter(f -> f.getName().equalsIgnoreCase(factionName)).findFirst()
				.ifPresent(Faction::outputAllDeputies);
			
	}
	
	public void clearFaction() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Введіть назву фракції, яку хочете очистити");
		String factionName = s.next();
		if(!isFaction(factionName)) 
			System.out.println("Такої фракції не існує");
		else 
			factions.stream().filter(f -> f.getName().equalsIgnoreCase(factionName)).findFirst()
			.ifPresent(Faction::clearAll);					
			
	}
	
	private boolean isFaction(String factionName) {

		return factions.stream().anyMatch(f->f.name.equalsIgnoreCase(factionName));
	}
	
}






























package les13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		
		while(true) {
			System.out.println("������ ����� ������� ��� ������ ������");
			String factionName = s.next();
			
			if(isFaction(factionName)) {
				System.out.println("���� ������� ��� ����");
				continue;
			}
			
			factions.add(new Faction(factionName));
			System.out.println("������ ������� " + factionName);
			break;
			

		}
	}
	
	public void removeFaction() {
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("������ ����� ������� ��� ������ ��������");
			String factionName = s.next();
			
			if(!isFaction(factionName)) {
				System.out.println("���� ������� �� ����");
				continue;
			}
			for (Faction f : factions) {
				if(f.getName().equals(factionName)) {
					factions.remove(f);
					System.out.println("�������� ������� " + factionName);
					return;
				}
			}
			
		
		}
		
	}
	
	public void outputAllFactions() {
		
		System.out.println("� ��� �������:\n");
		for (Faction f : factions)
			System.out.print(f.name + "\t");
		System.out.println();
	}
	
	public void addDeputy() {
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("������ ����� ������� �� ��� ������ ������ ��������");
			String factionName = s.next();
			
			if(!isFaction(factionName)) {
				System.out.println("���� ������� �� ����");
				continue;
			}
			for (Faction f : factions) {
				if(f.getName().equals(factionName)) {
					f.addDeputy();
					return;
				}
			}
			
			
		}
		
		
	}
	
	public void removeDeputy() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ ����� ������� � ��� ������ �������� ��������");
		String factionName = s.next();
		
		if(!isFaction(factionName)) {
			System.out.println("���� ������� �� ����");
			return;
		}
		for(Faction f : factions) {
			if(f.getName().equals(factionName)) {
				f.removeDeputy();
				break;
			}
		}
	}
	
	public void outputFactionBribeTakers() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ ����� �������, ��������� ��� ������ �������");
		String factionName = s.next();
		if(!isFaction(factionName)) {
			System.out.println("���� ������� �� ����");
			return;
		}
		
		for(Faction f : factions) {
			if(f.getName().equals(factionName)) {
				f.outputBribeTakers();
				break;
			}
		}
		
	}
		
	public void outputBiggestFactionBribeTaker() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ ����� �������, ���������� ��������� ��� ������ �������");
		String factionName = s.next();
		if(!isFaction(factionName)) {
			System.out.println("���� ������� �� ����");
			return;
		}
		
		for(Faction f : factions) {
			if(f.getName().equals(factionName)) {
				f.outputBiggestBribeTaker();
				break;
			}
		}
		
	}
	
	public void outputFactionDeputies() {
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("������ ����� �������, �������� ��� ������ �������:");
			String factionName = s.next();
			
			for (Faction f : factions) {
				if(f.getName().equals(factionName)) {
					System.out.println("�������� ������� " + f.getName());
					System.out.println(f);
					return;
				}
			}
			
			System.out.println("���� ������� �� ����");
		}
	}
	
	public void clearFaction() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ ����� �������, ��� ������ ��������");
		String factionName = s.next();
		if(!isFaction(factionName)) {
			System.out.println("���� ������� �� ����");
			return;
		}
		
		for(Faction f : factions) {
			if(f.getName().equals(factionName)) {
				f.clearAll();
				System.out.println("������� " + f.getName() + " �������");
				break;
			}
		}
	}
	
	private boolean isFaction(String factionName) {
		
		for(Faction f : factions) {
			if(f.getName().equalsIgnoreCase(factionName))
				return true;
		}
		return false;
	}
	
}






























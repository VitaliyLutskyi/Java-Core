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
		
		System.out.println("������ ���� ��������");
		deputyWeight = s.nextInt();
		System.out.println("������ ������ ��������");
		deputyHeight = s.nextInt();
		System.out.println("������ ������� ��������");
		deputyLastName = s.next();
		System.out.println("������ ��'� ��������");
		deputyFirstName = s.next();
		System.out.println("������ �� ��������");
		deputyAge = s.nextInt();
		System.out.println("������ �� � ������� ���������� (��� ��� �)");
		if(s.next().equalsIgnoreCase("���"))
			isDeputyBribeTaker = true;
		else
			isDeputyBribeTaker = false;
		
		deputies.add(new Deputy(deputyWeight, deputyHeight, deputyLastName, deputyFirstName, deputyAge, isDeputyBribeTaker));
	}
	
	public void removeDeputy() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ ������� �������� ����� ������ ��������");
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
			System.out.println("� ���� ������� ���� �������� � ����� ��������.");
	}
	
	public void outputBribeTakers() {
		
		System.out.println("\n��������� �������" + name + ":");
		Iterator<Deputy> iterator = deputies.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().isBribeTaker())
				System.out.println(iterator.next());
		}
	}
	
	public void outputBiggestBribeTaker() {
		
		Collections.sort(deputies, new DeputyBribeSizeComparator());
		
		if (!(deputies.get(0).getBribeSize()==deputies.get(1).getBribeSize()))
			System.out.println("��������� ��������: " + deputies.get(0));
		else {
			System.out.print("�������� ���������: ");
			for(Deputy d : deputies) {
				if(d.getBribeSize() == deputies.get(0).getBribeSize())
					System.out.println(d + ", ");
				else
					return;
			}			
		}	
	}
	
	public void outputAllDeputies() {
		
		System.out.println("�������� �������: ");
		for(Deputy d : deputies)
			System.out.println(d);
	}
	
	public void clearAll() {
		deputies.clear();
	}
}

































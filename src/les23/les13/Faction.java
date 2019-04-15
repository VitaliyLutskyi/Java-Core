package les23.les13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		deputies.get(deputies.size()-1).giveBribe();
		
	}
	
	public void removeDeputy() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ ������� �������� ����� ������ ��������");
		String deputyLastName = s.next();
		
		if (deputies.stream().anyMatch(d->d.getLastName().equalsIgnoreCase(deputyLastName))) {
			deputies = deputies.stream().filter(d->!(d.getLastName().equalsIgnoreCase(deputyLastName))).collect(Collectors.toList());
			System.out.println("�������� "+deputyLastName + "��������");
		}	
		else
			System.out.println("� ���� ������� ���� �������� � ����� ��������.");
		

	}
	
	public void outputBribeTakers() {
		
		System.out.println("\n��������� ������� " + name + ":");
		deputies.stream().filter(d->d.isBribeTaker()).forEach(System.out::println);

	}
	
	public void outputBiggestBribeTaker() {
		
		deputies = deputies.stream().sorted(Comparator.comparingInt(Deputy::getBribeSize).reversed()).collect(Collectors.toList());
		
		if(deputies.size()==0)
			System.out.println("���� ���������");
		else if (deputies.size()==1 || !(deputies.get(0).getBribeSize()==deputies.get(1).getBribeSize()))
			System.out.println("��������� ��������: " + deputies.get(0));
		else {
			System.out.print("�������� ���������: ");
			deputies.stream().filter(d->d.getBribeSize()==(deputies.get(0).getBribeSize())).forEach(System.out::println);

		}	
	}
	
	public void outputAllDeputies() {
		
		System.out.println("�������� ������� "+name+ ":");
		deputies.stream().forEach(System.out::println);

	}
	
	public void clearAll() {
		deputies.clear();
		System.out.println("������� " + name + " �������");
	}
}

































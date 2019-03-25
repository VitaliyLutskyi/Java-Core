package les15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class ZooClub {

		Map<Person, List<Pet>> map = new HashMap<Person, List<Pet>>();
		
		
		public void addMember() {
			
			String name;
			int age;
			Scanner s = new Scanner(System.in);
			
			System.out.println("������ ��� ������ ����� �����:");
			name = s.next();
			System.out.println("������ �� ������ ����� �����:");
			age = s.nextInt();
			//s.close();
			
			map.put(new Person(name, age), new ArrayList<Pet>());
			System.out.println("������ ������ ����� �����");
		}
		
		public void addPet() {
			
			String personName, type, petName;
			Scanner s = new Scanner(System.in);
			
			System.out.println("������ ��� ����� �����, ����� ������ ������ ��������:");
			personName = s.next();
			System.out.println("������ ��� ��������:");
			petName = s.next();
			System.out.println("������ ��� ��������:");
			type = s.next();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				if(next.getKey().getName().equalsIgnoreCase(personName)) {
					List<Pet> value = next.getValue();
					value.add(new Pet(petName, type));
					next.setValue(value);
					System.out.println("�������� ������.");
				}
			}
			
						
		}
		
		public void removePet() {
			
			String personName, petName;
			Scanner s = new Scanner(System.in);
			
			System.out.println("������ ��� ����� �����, � ����� ������ �������� ��������:");
			personName = s.next();
			System.out.println("������ ��� ��������:");
			petName = s.next();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				if(next.getKey().getName().equalsIgnoreCase(personName)) {
					Iterator<Pet> iterator2 = next.getValue().iterator();
					while(iterator2.hasNext()) {
						if(iterator2.next().getName().equalsIgnoreCase(petName)) {
							iterator2.remove();
							System.out.println("�������� ��������.");
						}
					}
				}
			}
		}
		
		public void removeMember() {
			
			String personName;
			int age;
			Scanner s = new Scanner(System.in);
			
			System.out.println("������ ��� ����� �����, ����� ������ ��������:");
			personName = s.next();
			System.out.println("������ �� ����� �����, ����� ������ ��������:");
			age = s.nextInt();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				if(next.getKey().equals(new Person(personName, age))) {
					iterator.remove();
					System.out.println("������ ����� ����� ��������.");
				}
			}
		}
		
		public void removePetFromAllMembers() {
			
			String type, petName;
			Scanner s = new Scanner(System.in);
			
			System.out.println("������ ��� ��������, ��� ������� ��������:");
			petName = s.next();
			System.out.println("������ ��� ��������, ��� ������� ��������:");
			type = s.next();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();			
				Iterator<Pet> iterator2 = next.getValue().iterator();
				while(iterator2.hasNext()) {
					if(iterator2.next().equals(new Pet(petName, type))) {
						iterator2.remove();
						System.out.println("�������� ��������.");
					}
				}
				
			}
			
		}

		@Override
		public String toString() {
			String out = "�������:";
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				out+="\n" + next.getKey().toString() + next.getValue().toString();
			}
			return out;
		}
		
}

































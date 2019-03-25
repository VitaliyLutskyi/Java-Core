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
			
			System.out.println("Введіть імя нового члена клубу:");
			name = s.next();
			System.out.println("Введіть вік нового члена клубу:");
			age = s.nextInt();
			//s.close();
			
			map.put(new Person(name, age), new ArrayList<Pet>());
			System.out.println("Додано нового члена клубу");
		}
		
		public void addPet() {
			
			String personName, type, petName;
			Scanner s = new Scanner(System.in);
			
			System.out.println("Введіть імя члена клубу, якому хочете додати тваринку:");
			personName = s.next();
			System.out.println("Введіть імя тваринки:");
			petName = s.next();
			System.out.println("Введіть тип тваринки:");
			type = s.next();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				if(next.getKey().getName().equalsIgnoreCase(personName)) {
					List<Pet> value = next.getValue();
					value.add(new Pet(petName, type));
					next.setValue(value);
					System.out.println("Тваринку додано.");
				}
			}
			
						
		}
		
		public void removePet() {
			
			String personName, petName;
			Scanner s = new Scanner(System.in);
			
			System.out.println("Введіть імя члена клубу, у якого хочете видалити тваринку:");
			personName = s.next();
			System.out.println("Введіть імя тваринки:");
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
							System.out.println("Тваринку видалено.");
						}
					}
				}
			}
		}
		
		public void removeMember() {
			
			String personName;
			int age;
			Scanner s = new Scanner(System.in);
			
			System.out.println("Введіть імя члена клубу, якого хочете видалити:");
			personName = s.next();
			System.out.println("Введіть вік члена клубу, якого хочете видалити:");
			age = s.nextInt();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				if(next.getKey().equals(new Person(personName, age))) {
					iterator.remove();
					System.out.println("Даного члена клубу видалено.");
				}
			}
		}
		
		public void removePetFromAllMembers() {
			
			String type, petName;
			Scanner s = new Scanner(System.in);
			
			System.out.println("Введіть імя тваринки, яку потрібно видалити:");
			petName = s.next();
			System.out.println("Введіть тип тваринки, яку потрібно видалити:");
			type = s.next();
			//s.close();
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();			
				Iterator<Pet> iterator2 = next.getValue().iterator();
				while(iterator2.hasNext()) {
					if(iterator2.next().equals(new Pet(petName, type))) {
						iterator2.remove();
						System.out.println("Тваринку видалено.");
					}
				}
				
			}
			
		}

		@Override
		public String toString() {
			String out = "Зооклуб:";
			
			Iterator<Entry<Person, List<Pet>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Person, List<Pet>> next = iterator.next();
				out+="\n" + next.getKey().toString() + next.getValue().toString();
			}
			return out;
		}
		
}

































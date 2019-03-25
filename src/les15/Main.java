package les15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ZooClub zooClub = new ZooClub();
		while(true) {
					
			Scanner s = new Scanner(System.in);
			
			System.out.println("\nВведіть 0 щоб вийти з програми");
			System.out.println("Введіть 1 щоб додати учасника клубу");
			System.out.println("Введіть 2 щоб додати тваринку до учасника клубу");
			System.out.println("Введіть 3 щоб видалити тваринку з учасника клубу");
			System.out.println("Введіть 4 щоб видалити учасника з клубу");
			System.out.println("Введіть 5 щоб видалити конкретну тваринку зі всіх власників");
			System.out.println("Введіть 6 щоб вивести на екран зооклуб");
			
			int n;
			try {
				n = s.nextInt();
			}
			catch(Exception e) {
				System.out.println("Ви повинні ввести ціле число від 1 до 6");
				continue;
			}
			
			switch(n) {
				case 0:
					System.exit(0);
				case 1:
					zooClub.addMember();
					break;
				case 2:
					zooClub.addPet();
					break;
				case 3:
					zooClub.removePet();
					break;
				case 4:
					zooClub.removeMember();
					break;
				case 5:
					zooClub.removePetFromAllMembers();
					break;
				case 6:
					System.out.println(zooClub);
					break;
			default: 
					System.out.println("Число повинне бути від 1 до 6");
			}
				
			
			}

	}

}

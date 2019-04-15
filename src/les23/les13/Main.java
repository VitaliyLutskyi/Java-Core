package les23.les13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Parliament parliament = Parliament.getParliament();
		while(true) {
			
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("\nВведіть 0 щоб вийти");
			System.out.println("Введіть 1 щоб додати фракцію");
			System.out.println("Введіть 2 щоб видалити конкретну фракцію");
			System.out.println("Введіть 3 щоб вивести усі  фракції");
			System.out.println("Введіть 4 щоб очистити конкретну фракцію");
			System.out.println("Введіть 5 щоб вивести конкретну фракцію");
			System.out.println("Введіть 6 щоб додати депутата в фракцію");
			System.out.println("Введіть 7 щоб видалити депутата з фракції");
			System.out.println("Введіть 8 щоб вивести список хабарників");
			System.out.println("Введіть 9 щоб вивести найбільшого хабарника");
			
			int n;
			try {
				n = s.nextInt();
			}
			catch(Exception e) {
				System.out.println("Ви повинні ввести ціле число від 1 до 9");
				continue;
			}
			
			switch(n) {
				case 0:
					return;
				case 1:
					parliament.addFaction();
					break;
				case 2:
					parliament.removeFaction();;
					break;
				case 3:
					parliament.outputAllFactions();;
					break;
				case 4:
					parliament.clearFaction();
					break;
				case 5:
					parliament.outputFactionDeputies();
					break;
				case 6:
					parliament.addDeputy();
					break;
				case 7:
					parliament.removeDeputy();
					break;
				case 8:
					System.out.println("Список хабарників:");
					parliament.getFactions().stream().forEach(Faction::outputBribeTakers);
					break;
				case 9:
					Faction allDep = new Faction("Всі депутати");
					
					parliament.getFactions().stream().forEach(f->allDep.getDeputies().addAll(f.getDeputies()));
					allDep.outputBiggestBribeTaker();
					break;
				default:
					System.out.println("Число повинно бути від 1 до 9");
			}
		}

	}

}

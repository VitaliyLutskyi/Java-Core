package les23.les14.max;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		
		Store shop = new Store();
		while(true) {
			
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("\nВведіть 0 щоб вийти з програми");
			System.out.println("Введіть 1 щоб додати товар");
			System.out.println("Введіть 2 щоб видалити товар");
			System.out.println("Введіть 3 щоб замінити товар");
			System.out.println("Введіть 4 щоб сортувати за назвою");
			System.out.println("Введіть 5 щоб сортувати за довжиною");
			System.out.println("Введіть 6 щоб сортувати за шириною");
			System.out.println("Введіть 7 щоб сортувати за вагою");
			System.out.println("Введіть 8 щоб вивести і-тий товар");
			
			int n;
			try {
				n = s.nextInt();
			}
			catch(Exception e) {
				System.out.println("Ви повинні ввести ціле число від 1 до 8");
				continue;
			}
			
			
			switch(n) {
				case 0:
					System.exit(0);
				case 1:
					shop.addCommodity();
					break;
				case 2:
					shop.removeCommodity();
					break;
				case 3:
					shop.replaceCommodity();
					break;
				case 4:
					System.out.println("\nВідсортовано за назвою");
					shop.getStore().stream().sorted((c1, c2)->c1.getName().
							compareToIgnoreCase(c2.getName())).forEach(System.out::println);
					break;
				case 5:
					System.out.println("\nВідсортовано за довжиною");
					shop.getStore().stream().sorted(Comparator.comparingInt(Commodity::getLength)).forEach(System.out::println);
					break;
				case 6:
					System.out.println("\nВідсортовано за шириною");
					shop.getStore().stream().sorted((c1, c2)->c1.getWidth()-c2.getWidth()).forEach(System.out::println);
					break;
				case 7:
					System.out.println("\nВідсортовано за вагою");
					shop.getStore().stream().sorted((c1, c2)->c1.getWeight()-c2.getWeight()).forEach(System.out::println);
					break;
				case 8:
					System.out.println("Введіть i:");
					int i = s.nextInt();
					if(i>=0 && i<shop.getStore().size()) {
						System.out.print(i+"-ий елемент колекції: ");
						System.out.println(shop.getStore().stream().collect(Collectors.toList()).get(i));			
					}
					else
						System.out.println("Не коректне значення i");
					break;
			
					}
				
				
			}
		
		


	}

}

package les14.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Store shop = new Store();
		while(true) {
			
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("\nВведіть 0 щоб вийти з програми");
			System.out.println("Введіть 1 щоб додати товар");
			System.out.println("Введіть 2 щоб видалити товар");
			System.out.println("Введіть 3 щоб замінити товар");
			System.out.println("Введіть 4 щоб сортувати за назвоню");
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
			
			ArrayList<Commodity> shopCopy = new ArrayList<Commodity>();
			shopCopy.addAll(shop.getStore());
			
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
					Collections.sort(shopCopy, new CommodityNameComparator());
					System.out.println("\nВідсортовано за назвою");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 5:
					Collections.sort(shopCopy, new CommodityLengthComparator());
					System.out.println("\nВідсортовано за довжиною");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 6:
					Collections.sort(shopCopy, new CommodityWidthComparator());
					System.out.println("\nВідсортовано за шириною");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 7:
					Collections.sort(shopCopy, new CommodityWeightComparator());
					System.out.println("\nВідсортовано за вагою");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 8:
					System.out.println("Введіть i:");
					int i = s.nextInt();
					System.out.println(shopCopy.get(i-1));
					break;
			
					}
				
				
			}
		


	}

}

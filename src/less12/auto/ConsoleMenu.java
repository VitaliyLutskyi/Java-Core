package less12.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleMenu {

	public static void main(String[] args) {
		
		Random r = new Random();
		int size = new Random().nextInt(10)+1;
		List<Auto> autos = new ArrayList<>(size); 
		
		for(int i=0;i<size;i++) {
				autos.add(new Auto(r.nextInt(450)+50, r.nextInt(70)+1949, new Helm(r.nextInt(10)+12, r.nextInt(2)), new Engine(r.nextInt(7)+2)));	
		}
		while(true) {
		System.out.println("Натисніть 1, щоб вивести дані елементів масиву...");
		System.out.println("Натисніть 2, щоб для всіх обєктів даного масиву засетати одинаковий  обєкт класу Авто ...");
		System.out.println("Натисніть 3, щоб вийти...");
		
		Scanner sc = new Scanner(System.in);
		int number=0;
		
		try{
			number = sc.nextInt();
		}
		finally {
			switch (number) {
			case 1:
				System.out.println(autos);
				break;
			case 2:
				Auto auto = new Auto(r.nextInt(450)+50, r.nextInt(70)+1949, new Helm(r.nextInt(10)+12, r.nextInt(2)), new Engine(r.nextInt(7)+2));
				for(int i=0;i<autos.size();i++)
					autos.set(i, auto);
				System.out.println("Для всіх обєктів класу Авто встановлено новий одинаковий обєкт...");
				break;
			case 3:
				return;
			default:
				System.out.println("Не коректно введені дані! Введіть 1, 2 або 3...");
			}
		}
		 
		
		}

	}

}

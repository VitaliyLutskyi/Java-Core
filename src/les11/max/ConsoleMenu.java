package les11.max;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ConsoleMenu {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		Auto [][] autos = new Auto [r.nextInt(10)+1][r.nextInt(10)+1];
		
		for(int i=0;i<autos.length;i++) {
			for(int j=0;j<autos[i].length;j++) 
				autos[i][j] = new Auto(r.nextInt(450)+50, r.nextInt(70)+1949, new Helm(r.nextInt(10)+12, r.nextInt(2)), new Engine(r.nextInt(7)+2));	
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
				System.out.println(Arrays.deepToString(autos));
				break;
			case 2:
				Auto auto = new Auto(r.nextInt(450)+50, r.nextInt(70)+1949, new Helm(r.nextInt(10)+12, r.nextInt(2)), new Engine(r.nextInt(7)+2));
				for(int i=0;i<autos.length;i++)
					Arrays.fill(autos[i], auto);
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

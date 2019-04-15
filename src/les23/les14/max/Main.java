package les23.les14.max;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		
		Store shop = new Store();
		while(true) {
			
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n������ 0 ��� ����� � ��������");
			System.out.println("������ 1 ��� ������ �����");
			System.out.println("������ 2 ��� �������� �����");
			System.out.println("������ 3 ��� ������� �����");
			System.out.println("������ 4 ��� ��������� �� ������");
			System.out.println("������ 5 ��� ��������� �� ��������");
			System.out.println("������ 6 ��� ��������� �� �������");
			System.out.println("������ 7 ��� ��������� �� �����");
			System.out.println("������ 8 ��� ������� �-��� �����");
			
			int n;
			try {
				n = s.nextInt();
			}
			catch(Exception e) {
				System.out.println("�� ������ ������ ���� ����� �� 1 �� 8");
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
					System.out.println("\n³���������� �� ������");
					shop.getStore().stream().sorted((c1, c2)->c1.getName().
							compareToIgnoreCase(c2.getName())).forEach(System.out::println);
					break;
				case 5:
					System.out.println("\n³���������� �� ��������");
					shop.getStore().stream().sorted(Comparator.comparingInt(Commodity::getLength)).forEach(System.out::println);
					break;
				case 6:
					System.out.println("\n³���������� �� �������");
					shop.getStore().stream().sorted((c1, c2)->c1.getWidth()-c2.getWidth()).forEach(System.out::println);
					break;
				case 7:
					System.out.println("\n³���������� �� �����");
					shop.getStore().stream().sorted((c1, c2)->c1.getWeight()-c2.getWeight()).forEach(System.out::println);
					break;
				case 8:
					System.out.println("������ i:");
					int i = s.nextInt();
					if(i>=0 && i<shop.getStore().size()) {
						System.out.print(i+"-�� ������� ��������: ");
						System.out.println(shop.getStore().stream().collect(Collectors.toList()).get(i));			
					}
					else
						System.out.println("�� �������� �������� i");
					break;
			
					}
				
				
			}
		
		


	}

}

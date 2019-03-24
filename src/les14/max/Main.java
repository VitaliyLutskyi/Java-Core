package les14.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Store shop = new Store();
		while(true) {
			
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n������ 0 ��� ����� � ��������");
			System.out.println("������ 1 ��� ������ �����");
			System.out.println("������ 2 ��� �������� �����");
			System.out.println("������ 3 ��� ������� �����");
			System.out.println("������ 4 ��� ��������� �� �������");
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
					System.out.println("\n³���������� �� ������");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 5:
					Collections.sort(shopCopy, new CommodityLengthComparator());
					System.out.println("\n³���������� �� ��������");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 6:
					Collections.sort(shopCopy, new CommodityWidthComparator());
					System.out.println("\n³���������� �� �������");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 7:
					Collections.sort(shopCopy, new CommodityWeightComparator());
					System.out.println("\n³���������� �� �����");
					for(Commodity c:shopCopy)
						System.out.println(c);
					break;
				case 8:
					System.out.println("������ i:");
					int i = s.nextInt();
					System.out.println(shopCopy.get(i-1));
					break;
			
					}
				
				
			}
		


	}

}

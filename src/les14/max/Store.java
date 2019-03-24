package les14.max;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Store {
	
	LinkedHashSet<Commodity> store = new LinkedHashSet<Commodity>();
	
	
	public LinkedHashSet<Commodity> getStore() {
		return store;
	}

	public void addCommodity() {
		
		Scanner s = new Scanner(System.in);
		int length, width, weight;
		String name;
		
		System.out.println("������ ����� ������");
		name = s.next();
		System.out.println("������ ������� ������");
		length = s.nextInt();
		System.out.println("������ ������ ������");
		width = s.nextInt();
		System.out.println("������ ���� ������");
		weight = s.nextInt();
		
		store.add(new Commodity(name, length, width, weight));
		System.out.println("����� ������.");
	}
	
	public void removeCommodity() {
		
		Scanner s = new Scanner(System.in);
		String name;
		
		System.out.println("������ ����� ������ ���� ������� ��������");
		name = s.next();
		Iterator<Commodity> iterator = store.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getName().equalsIgnoreCase(name))
				iterator.remove();
		}
		
		System.out.println("����� ��������.");
	}
	
public void replaceCommodity() {
		
		Scanner s = new Scanner(System.in);
		String name;
		int length, width, weight;
		
		System.out.println("������ ����� ������ ���� ������� �������");
		name = s.next();
		ArrayList<Commodity> storeCopy = new ArrayList<Commodity>();
		storeCopy.addAll(store);
		int i;
		for(i=0; i<storeCopy.size(); i++) {
			if (storeCopy.get(i).getName().equalsIgnoreCase(name))
				break;
		}
		
		System.out.println("������ ����� ������ ������");
		name = s.next();
		System.out.println("������ ������� ������");
		length = s.nextInt();
		System.out.println("������ ������ ������");
		width = s.nextInt();
		System.out.println("������ ���� ������");
		weight = s.nextInt();
		
		storeCopy.set(i, new Commodity(name, length, width, weight));
		store.clear();
		store.addAll(storeCopy);
		System.out.println("����� �������.");
	}
	
	
}


























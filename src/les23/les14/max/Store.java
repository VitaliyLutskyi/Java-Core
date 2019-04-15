package les23.les14.max;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Store {
	
	Set<Commodity> store = new LinkedHashSet<Commodity>();
	

	public Set<Commodity> getStore() {
		return store;
	}
	
	public void setStore(Set<Commodity> store) {
		this.store = store;
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
		store.forEach(System.out::println);
		
	}
	
	public void removeCommodity() {
		
		Scanner s = new Scanner(System.in);
		String name;
		
		System.out.println("������ ����� ������ ���� ������� ��������");
		name = s.next();
		Commodity commodity = store.stream().filter(c->c.getName().equalsIgnoreCase(name)).findFirst().get();
		store.remove(commodity);
		System.out.println("����� ��������.");
		store.forEach(System.out::println);
	}

	public void replaceCommodity() {

		Scanner s = new Scanner(System.in);
		int length, width, weight;

		System.out.println("������ ����� ������ ���� ������� �������");
		String name = s.next();
		System.out.println("������ ����� ������ ������");
		String nameNew = new String(s.next());
		System.out.println("������ ������� ������");
		length = s.nextInt();
		System.out.println("������ ������ ������");
		width = s.nextInt();
		System.out.println("������ ���� ������");
		weight = s.nextInt();

		Commodity commodity = store.stream().filter(c->c.getName().equalsIgnoreCase(name)).findFirst().get();
		commodity.setName(nameNew);
		commodity.setLength(length);
		commodity.setWeight(weight);
		commodity.setWidth(width);
		System.out.println("����� �������.\n");
		store.forEach(System.out::println);
	}

}


























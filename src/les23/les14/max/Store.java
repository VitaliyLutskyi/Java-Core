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
		
		System.out.println("Введіть назву товару");
		name = s.next();
		System.out.println("Введіть довжину товару");
		length = s.nextInt();
		System.out.println("Введіть ширину товару");
		width = s.nextInt();
		System.out.println("Введіть масу товару");
		weight = s.nextInt();
		
		store.add(new Commodity(name, length, width, weight));
		System.out.println("Товар додано.");
		store.forEach(System.out::println);
		
	}
	
	public void removeCommodity() {
		
		Scanner s = new Scanner(System.in);
		String name;
		
		System.out.println("Введіть назву товару який потрібно видалити");
		name = s.next();
		Commodity commodity = store.stream().filter(c->c.getName().equalsIgnoreCase(name)).findFirst().get();
		store.remove(commodity);
		System.out.println("Товар видалено.");
		store.forEach(System.out::println);
	}

	public void replaceCommodity() {

		Scanner s = new Scanner(System.in);
		int length, width, weight;

		System.out.println("Введіть назву товару який потрібно замінити");
		String name = s.next();
		System.out.println("Введіть назву нового товару");
		String nameNew = new String(s.next());
		System.out.println("Введіть довжину товару");
		length = s.nextInt();
		System.out.println("Введіть ширину товару");
		width = s.nextInt();
		System.out.println("Введіть масу товару");
		weight = s.nextInt();

		Commodity commodity = store.stream().filter(c->c.getName().equalsIgnoreCase(name)).findFirst().get();
		commodity.setName(nameNew);
		commodity.setLength(length);
		commodity.setWeight(weight);
		commodity.setWidth(width);
		System.out.println("Товар замінено.\n");
		store.forEach(System.out::println);
	}

}


























package les19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
			
		Employee e = new Employee("Petro", 20, 1500);
		Methods.serialize(e);
		Employee eDeserialized = (Employee) Methods.deserialize();
		System.out.println(eDeserialized);
		
		Employee e1 = new Employee("Oleg", 30, 1200);
		Methods.serialize(e1);
		Employee e1Deserialized = (Employee) Methods.deserialize();
		System.out.println(e1Deserialized);
		
		List<Employee> list = new ArrayList<>();
		list.add(e);
		list.add(e1);
		list.add(new Employee("John", 11, 800));
		list.add(new Employee("Ruslan", 17, 1000));
		list.add(new Employee("Tom", 21, 600));
		list.add(new Employee("Andry", 43, 2000));
		
		Methods.serialize(list);
		List<Employee> listDeserialized = (List<Employee>) Methods.deserialize();
		System.out.println("\nDeserialized list:");
		for (Employee emp : listDeserialized) 
			System.out.println(emp);
		
		
	}
}
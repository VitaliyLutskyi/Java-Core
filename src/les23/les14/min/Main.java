package les23.les14.min;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
			
		Set<Student> set = new LinkedHashSet<>();
		set.add(new Student("Jorge", 20));
		set.add(new Student("Peter", 19));
		set.add(new Student("Michael", 21));
		set.add(new Student("John", 17));
		set.add(new Student("Eugene", 18));
		set.add(new Student("Simon", 20));
		set.add(new Student("Taras", 20));
		set.add(new Student("Yurii", 21));
		set.add(new Student("Taras", 20));
		set.add(new Student("Taras", 19));
		
		System.out.println("До сортування:");
		set.stream().forEach(System.out::println);
		
		System.out.println("\nПісля сортування по імені:");
		set.stream().sorted().forEach(System.out::println);
		
		System.out.println("\nПісля сортування за всіма полями:");
		set.stream().sorted(new StudentAllFieldsComparator()).forEach(System.out::println);
		

	}

}

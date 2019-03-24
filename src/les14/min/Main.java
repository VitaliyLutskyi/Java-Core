package les14.min;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

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
		for(Student s :set)
			System.out.println(s);
		
		Set<Student> setCopy = new TreeSet<Student>();
		setCopy.addAll(set);
		
		System.out.println("\nПісля сортування по імені:");
		for(Student s :setCopy)
			System.out.println(s);
		
		setCopy = new TreeSet<Student>(new StudentAllFieldsComparator());
		setCopy.addAll(set);
		
		System.out.println("\nПісля сортування за всіма полями:");
		for(Student s :setCopy)
			System.out.println(s);
	}

}

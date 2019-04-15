package les23.les14.min;

import java.util.Comparator;

public class StudentAllFieldsComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		if (o1.getName().compareToIgnoreCase(o2.getName()) >0)
			return 1;
		else if (o1.getName().compareToIgnoreCase(o2.getName()) <0)
			return -1;
		else {
			if (o1.getAge() > o2.getAge())
				return 1;
			else if (o1.getAge() < o2.getAge())
				return -1;
		}
		return 0;
	}

}

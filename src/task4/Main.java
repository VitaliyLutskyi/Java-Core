package task4;

interface EquilateralTriangle{
	Triangle create(double c);
}

interface CustomTriangle{
	Triangle create(double b, double c);
}

public class Main {

	public static void main(String[] args) {

		EquilateralTriangle eqtr  = Triangle::new;
		CustomTriangle csttr =Triangle::new;
		
		System.out.println("That's equilateral triangle sides:" + eqtr.create(15));
		System.out.println("That's custom triangle sides:" + csttr.create(15, 7));
	}

}

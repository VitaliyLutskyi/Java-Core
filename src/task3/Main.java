package task3;

interface Numeric<T>{
	T extremeValue();
}
public class Main {

	public static void main(String[] args) {
			
		Numeric<Double> doubleMin = ()-> Double.MIN_VALUE;
		Numeric<Double> doubleMax = ()-> Double.MAX_VALUE;
		Numeric<Float> floatMin = ()-> Float.MIN_VALUE;
		Numeric<Float> floatMax = ()-> Float.MAX_VALUE;

		System.out.println("The min float value is: " + floatMin.extremeValue());
		System.out.println("The max float value is: " + floatMax.extremeValue());
		System.out.println("The min double value is: " + doubleMin.extremeValue());
		System.out.println("The max double value is: " + doubleMax.extremeValue());
	}

}

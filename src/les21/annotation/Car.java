package les21.annotation;

public class Car {
	
	String manufacturer;
	String model;
	
	@MyAnnotation(id=1, description="Must be between 1990 and 2019")
	int year;
	
	@MyAnnotation(id=2, description="Must be between 1.0 and 6.0")
	double engine;
	
	@MyAnnotation(id=3)
	String transmission;
	
}

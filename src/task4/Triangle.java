package task4;

public class Triangle {
	
	private double a,b,c;
	public Triangle() {
		a=b=c=10;
	}
	public Triangle(double c) {
		this();
		this.c=c;
	}
	public Triangle(double b, double c) {
		this(c);
		this.b=b;
	}
	public String toString() {		
		return ("\na="+a+" b="+b+" c="+c);
	}
}

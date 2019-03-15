package les11.max;

public class Auto {

	private int horsePower, year;
	private Helm helm;
	private Engine engine;
	
	public Auto(int horsePower, int year, Helm helm, Engine engine) {
		this.horsePower = horsePower;
		this.year = year;
		this.helm = helm;
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Auto [horsePower=" + horsePower + ", year=" + year + ", helm=" + helm + ", engine=" + engine + "]";
	}

	
	
	
	
	
	
}

package les16.reflection;

public class Car implements Comparable<Car>{
	
	public int productionYear;
	public String manufacturer;
	private String model;
	private double engine;
	
	public Car() {}
	
	public Car(int productionYear, String manufacturer) {
		this.productionYear = productionYear;
		this.manufacturer = manufacturer;
	}
	
	public Car(int productionYear, String manufacturer, String model, double engine) {
		this.productionYear = productionYear;
		this.manufacturer = manufacturer;
		this.model = model;
		this.engine = engine;
	}
	
	public void setYearsOld(int yearsOld, String ownerName) {
		this.productionYear = 2019-yearsOld;
		System.out.println(ownerName+"'s car is produced in "+productionYear);
	}
	
	public void getInfo(String ownerName) {
		System.out.println(ownerName+"'s "+manufacturer+" "+model+" is "+(2019-productionYear) + " years old.");
	}
	
	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [productionYear=" + productionYear + ", manufacturer=" + manufacturer + ", model=" + model
				+ ", engine=" + engine + "]";
	}

	@Override
	public int compareTo(Car o) {
		
		return this.manufacturer.compareToIgnoreCase(o.getManufacturer());
	}
	
	
	
}

package les11.max;

public class Helm {
	private int wheelDiameter;
	private String material;
	String[] materials = {"Шкіра", "Алькантара"};
	
	public Helm(int wheelDiameter, int materialNumber) {
		
		this.wheelDiameter = wheelDiameter;
		this.material = materials[materialNumber];
	}

	@Override
	public String toString() {
		return "Helm [wheelDiameter=" + wheelDiameter + ", material=" + material + "]";
	}
	
	
	
}

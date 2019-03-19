package less12.auto;

import java.util.ArrayList;
import java.util.List;

public class Helm {
	private int wheelDiameter;
	private String material;
	List<String> materials = new ArrayList<>(2);

	public Helm(int wheelDiameter, int materialNumber) {
		materials.add("Шкіра");
		materials.add("Алькантара");
		this.wheelDiameter = wheelDiameter;
		this.material = materials.get(materialNumber);
	}

	@Override
	public String toString() {
		return "Helm [wheelDiameter=" + wheelDiameter + ", material=" + material + "]";
	}
}

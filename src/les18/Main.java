package les18;


public class Main {

	public static void main(String[] args) {
		
		Map<Integer, String> map= new Map<>();
		
		map.addEntry(6, "John");
		map.addEntry(4, "Mike");
		map.addEntry(-8, "Tom");
		map.addEntry(16, "Sam");
		map.addEntry(0, "Peter");
		map.addEntry(66, "Tim");
		map.addEntry(1, "Sara");
		map.addEntry(35, "July");
		
		map.outputKeysSet();
		map.outputValuesList();
		map.outputAllMap();
		
		map.removeByKey(4);
		map.removeByValue("Tim");
		map.outputAllMap();
	}

}

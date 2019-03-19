package les12.arraylist;

public class Main {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList(6);
		System.out.println(list);
		
		list.add("Tom");
		list.add(20);
		list.add('W');
		list.add(7.64);
		list.add(100);
		list.add("Auto");
		list.add("Logos");
		list.add(20000);
		list.add(100.23);
		list.add('^');
		list.add("testing");
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		list.remove(4);
		list.remove(8);
		list.remove(5);
		list.remove(6);
		System.out.println(list);
	}

}

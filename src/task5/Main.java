package task5;

interface Amphibia{
	void toDo();
}

public class Main {

	public static void main(String[] args) {
			
		Amphibia frogEat = ()->System.out.println("I'm eating!");
		Amphibia frogSleep = ()->System.out.println("I'm sleeping!");
		Amphibia frogSwim = ()->System.out.println("I'm swimming!");
		Amphibia frogWalk = ()->System.out.println("I'm walking!");
		
		frogEat.toDo();
		frogSleep.toDo();
		frogSwim.toDo();
		frogWalk.toDo();

	}

}

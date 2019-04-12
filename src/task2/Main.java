package task2;

import java.util.Random;

interface Coin {
	void coinThrow();
}

public class Main {

	public static void main(String[] args) {
		
		Coin newThrow = ()->{
			Random r = new Random();
			String side = r.nextBoolean() ? "eagle" : "tackle";
			System.out.println("That's " + side);
		};
		
		newThrow.coinThrow();
		newThrow.coinThrow();
		newThrow.coinThrow();
		newThrow.coinThrow();
		newThrow.coinThrow();
	}

}

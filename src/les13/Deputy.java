package les13;

import java.util.Scanner;

public class Deputy extends Human{
	
	String lastName;
	String firstName;
	int age;
	boolean bribeTaker;
	int bribeSize;
	
	public Deputy(int weight, int height, String lastName, String firstName, int age, boolean bribeTaker) {
		super(weight, height);
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.bribeTaker = bribeTaker;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribeTaker() {
		return bribeTaker;
	}

	public void setBribeTaker(boolean bribeTaker) {
		this.bribeTaker = bribeTaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	@Override
	public String toString() {
		String isBribeTaker = (bribeTaker) ? "Бере хабарі!" : "Не бере хабарів!";
		String bribeSize = (this.bribeSize>0) ? ((Integer) this.bribeSize).toString() : "";
		return "Депутат " + lastName + " " + firstName + " Вік: " + age + "р. "
				+ isBribeTaker + ", Розмір хабаря(якщо хабарник): " + bribeSize;
	}
	
	
	public void giveBribe() {
		
		if(!bribeTaker)
			System.out.println("Цей депутат не бере хабарів");
		else {
			Scanner s = new Scanner(System.in);
			
			int bribeSize = s.nextInt();
			if (bribeSize > 5000) 
				System.out.println("Міліція увязнить депутата");
			else
				this.bribeSize = bribeSize;
				
		}
	}
	
}

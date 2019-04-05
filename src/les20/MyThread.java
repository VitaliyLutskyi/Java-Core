package les20;

import java.util.Scanner;

public class MyThread extends Thread{
	
	private int delay;
	private int number;
	private int[] arr ;
	
	public MyThread(int delay) {
		super();
		this.delay = delay;
	}


	@Override
	public synchronized void run() {
		System.out.println("\nWrite an amount of Fibonacci numbers, must be >2:");
		Scanner s = new Scanner(System.in);
		number = s.nextInt();
		arr = new int[number];
		arr[0]=arr[1]=1;
		for(int i=2; i<arr.length; i++) 
			arr[i]=arr[i-1]+arr[i-2];
		System.out.print("\nÏîò³ê Thread : ");

		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			try {
				Thread.sleep(delay);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.print("...");
		
		
	}
	
	
}

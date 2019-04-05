package les20;

import java.util.Scanner;

public class RunnableThread implements Runnable{
	
	private int delay;
	private int number;
	private int[] arr ;
	
	public RunnableThread(int delay) {
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
		System.out.print("\nÏîò³ê Runnable :... ");
		
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
			try {
				Thread.sleep(delay);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		s.close();
		
	}
	
	
}

package les20;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread thread = new MyThread(1000);
		thread.start();
		
		RunnableThread runnable = new RunnableThread(1000);
		Thread t = new Thread(runnable);
		
		thread.join();
		t.start();
	}

}

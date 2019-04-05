package les20.max;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import les20.MyThread;
import les20.RunnableThread;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService es1 = Executors.newSingleThreadExecutor();
		MyThread t = new MyThread(1000);
		es1.execute(t);
		es1.shutdown();
		es1.awaitTermination(30, TimeUnit.SECONDS);
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new RunnableThread(1000));
		
		
	
	}
}

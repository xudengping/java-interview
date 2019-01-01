package xdp.test.interview.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如何控制多线程的执行顺序
 * Executors.newSingleThreadExecutor()
 * @author EasonXu
 *
 */
public class MultiThread2 {

	static Thread thread1 = new Thread(new Runnable() {

		@Override
		public void run() {
			System.out.println("thread1");

		}
	});

	static Thread thread2 = new Thread(new Runnable() {

		@Override
		public void run() {
			System.out.println("thread2");

		}
	});

	static Thread thread3 = new Thread(new Runnable() {

		@Override
		public void run() {
			System.out.println("thread3");

		}
	});

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(thread1);
		executorService.submit(thread2);
		executorService.submit(thread3);
	}

}

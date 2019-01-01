package xdp.test.interview.multithread;

/**
 * 如何控制多线程的执行顺序
 * join
 * @author EasonXu
 *
 */
public class MultiThread1 {

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

		thread1.start();
		thread1.join();
		thread2.start();
		thread1.join();
		thread3.start();
	}

}

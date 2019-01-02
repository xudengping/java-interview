package xdp.test.interview.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class RuunableCallableTest {
	
	@Test
	public void test1() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
			}
			
		};
		
		
		
		// 该方法返回Future对象，Future.get()线程结束返回null
		Future f = executorService.submit(task1);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main结束");
	}
	
	@Test
	public void test2() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
				// 无返回值
			}
			
		};
		
		// 该方法返回Future对象，Future.get()线程结束返回result,可以上线Runnable带返回值
		String result = "sss";
		Future<String> f = executorService.submit(task1, result);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main结束");
	}
	
	@Test
	public void test3() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Callable task1 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
				// 有返回值
				return "Callable1";
			}
		};
		
		
		
		// 该方法返回Future对象，Future.get()线程结束返回结果
		Future<String> f = executorService.submit(task1);
		String object = f.get();
		System.out.println(object);
		
		System.out.println("main结束");
	}
	
	@Test
	public void test4() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
				// 无返回值
			}
			
		};
		
		
		//异步执行
		executorService.execute(task1);
		
		System.out.println("main结束");
	}
	
	@Test
	public void test5() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
			}
			
		};
		
		
		
		// 也可以实现异步调用，只要不调用get方法阻塞线程
		executorService.submit(task1);
		
		System.out.println("main结束");
	}
	
	@Test
	public void test6() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
			}
			
		};
		
		Callable<Object> callable = Executors.callable(run1);
		Future<Object> f = executorService.submit(callable);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main结束");
	}
	
	@Test
	public void test7() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("线程task1 执行开始");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("线程task1 执行完毕");
			}
			
		};
		
		String res = "res";
		Callable<String> callable = Executors.callable(run1,res);
		Future<String> f = executorService.submit(callable);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main结束");
	}

}

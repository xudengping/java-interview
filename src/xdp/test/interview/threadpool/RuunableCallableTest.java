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
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
			}
			
		};
		
		
		
		// �÷�������Future����Future.get()�߳̽�������null
		Future f = executorService.submit(task1);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main����");
	}
	
	@Test
	public void test2() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
				// �޷���ֵ
			}
			
		};
		
		// �÷�������Future����Future.get()�߳̽�������result,��������Runnable������ֵ
		String result = "sss";
		Future<String> f = executorService.submit(task1, result);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main����");
	}
	
	@Test
	public void test3() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Callable task1 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
				// �з���ֵ
				return "Callable1";
			}
		};
		
		
		
		// �÷�������Future����Future.get()�߳̽������ؽ��
		Future<String> f = executorService.submit(task1);
		String object = f.get();
		System.out.println(object);
		
		System.out.println("main����");
	}
	
	@Test
	public void test4() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
				// �޷���ֵ
			}
			
		};
		
		
		//�첽ִ��
		executorService.execute(task1);
		
		System.out.println("main����");
	}
	
	@Test
	public void test5() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
			}
			
		};
		
		
		
		// Ҳ����ʵ���첽���ã�ֻҪ������get���������߳�
		executorService.submit(task1);
		
		System.out.println("main����");
	}
	
	@Test
	public void test6() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
			}
			
		};
		
		Callable<Object> callable = Executors.callable(run1);
		Future<Object> f = executorService.submit(callable);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main����");
	}
	
	@Test
	public void test7() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("�߳�task1 ִ�п�ʼ");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�task1 ִ�����");
			}
			
		};
		
		String res = "res";
		Callable<String> callable = Executors.callable(run1,res);
		Future<String> f = executorService.submit(callable);
		Object object = f.get();
		System.out.println(object);
		
		System.out.println("main����");
	}

}

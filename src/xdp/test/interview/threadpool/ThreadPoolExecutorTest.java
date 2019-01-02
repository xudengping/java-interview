package xdp.test.interview.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolExecutorTest {
	
	
	@Test
	public void testFixedThreadPool() throws InterruptedException {
	
		//ExecutorService executorService = Executors.newFixedThreadPool(1);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, 
				new LinkedBlockingQueue<Runnable>(1),new RejectedExecutionHandler() {
					
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.out.println("�̱߳��ܾ�"+r);
						new RejectedExecutionException("�ܾ���Ϣ:"+r);
						
					}
				});
		
		Runnable[] taskList = new Runnable[3];
		for(int i=0;i<3;i++) {
			final int index = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("�߳�task"+index+" ִ�п�ʼ");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("�߳�task"+index+" ִ�����");
				}
				
			};
			taskList[i] = task;
		}
		System.out.println(taskList.length);
		for(int i=0;i<taskList.length;i++) {
			threadPoolExecutor.execute(taskList[i]);
		}
		
		TimeUnit.SECONDS.sleep(11);
		System.out.println("main ִ�����");
	}
	
	@Test
	public void testSingleThreadExecutor() throws InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Runnable[] taskList = new Runnable[3];
		for(int i=0;i<3;i++) {
			final int index = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("�߳�task"+index+" ִ�п�ʼ");
					System.out.println("�߳�task"+index+" ִ�����");
				}
				
			};
			taskList[i] = task;
		}
		System.out.println(taskList.length);
		for(int i=0;i<taskList.length;i++) {
			executorService.execute(taskList[i]);
		}
		
		TimeUnit.SECONDS.sleep(5);
		System.out.println("main ִ�����");
		
	}
	
	@Test
	public void testCacheThreadPool() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Runnable[] taskList = new Runnable[3];
		for(int i=0;i<3;i++) {
			final int index = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("�߳�task"+index+" ִ�п�ʼ");
					System.out.println("�߳�task"+index+" ִ�����");
				}
				
			};
			taskList[i] = task;
		}
		System.out.println(taskList.length);
		for(int i=0;i<taskList.length;i++) {
			executorService.execute(taskList[i]);
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println("main ִ�����");
	}
	
	@Test
	public void testScheduledThreadPool() throws InterruptedException {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		// �ӳ�ִ��
		scheduledExecutorService.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("delay 3s");
				
			}
		}, 3, TimeUnit.SECONDS);
		// ������ִ��
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			   public void run() {
				    System.out.println("delay 1 seconds, and excute every 3 seconds");
				   }
				  }, 1, 3, TimeUnit.SECONDS);
		
	}

}

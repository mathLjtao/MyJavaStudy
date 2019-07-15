package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.c_lock;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	private Semaphore sem=new Semaphore(3,true);//指定可以三个线程访问，公平策略
	private static int i=0;
	class Task implements Runnable{
		private String name;
		public Task(String name){
			this.name=name;
		}
		@Override
		public void run() {
			try {
				sem.acquire();//拿走一个许可
				//smp.acquire(int permits);//使用有参数方法可以使用permits个许可
			
				System.out.println("Thread "+name+" is working");
				System.out.println("在等待的线程数目："+ sem.getQueueLength());
				//最多有三个线程同时访问work()方法
				work(name);
				System.out.println("Thread "+name+" is over");
				
			} catch (Exception e) {
				
			}
			finally{
				sem.release();//放回去
			}
		}
	}
	public static void work(String name){
		Random ran=new Random();
		try {
			int worktime=ran.nextInt(1000);
			i++;
			Thread.sleep(5000);
			System.out.println("Thread "+name+" worktime is "+worktime+",i="+i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

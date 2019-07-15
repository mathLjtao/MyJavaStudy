package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.c_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
	public static void main(String[] args) throws InterruptedException {
		Thread first =new Thread(CreateTask(),"FirstThread");
		Thread second =new Thread(CreateTask(),"SecondThread");
		first.start();
		
		second.start();
		
		Thread.sleep(600);
		second.interrupt();
	
	}
	public static Runnable CreateTask(){
		
		return new Runnable(){
			Lock lock =new  ReentrantLock();
			@Override
			public void run() {
				while (true){
					
					try {
						if(lock.tryLock()){
							try {
								System.out.println("locked "+Thread.currentThread().getName());
								Thread.sleep(1000);
							} catch (Exception e) {
							}
							finally{
								lock.unlock();
								System.out.println("unlock "+Thread.currentThread().getName());
							}
							break;
						}
						else{
							System.out.println("unable to lock "+Thread.currentThread().getName());
						}
					} catch (Exception e) {
						System.out.println(Thread.currentThread().getName()+" is Interrupted");
					}
				}
			}
		};
	}
}

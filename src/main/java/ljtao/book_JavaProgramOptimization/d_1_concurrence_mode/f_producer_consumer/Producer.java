package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.f_producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
	private volatile boolean isRunning=true;
	private BlockingQueue<PCData> queue;
	//AtomicInteger是一个提供原子操作的Integer类，通过线程安全的方式操作加减。
	private static AtomicInteger count=new AtomicInteger();
	private static final int SLEEPTIME=1000;
	public Producer(BlockingQueue<PCData> queue){
		this.queue=queue;
	}
	@Override
	public void run() {
		PCData data=null;
		Random r=new Random();
		System.out.println("start producer id="+Thread.currentThread().getId());
		try {
			while(isRunning){
				Thread.sleep(r.nextInt(SLEEPTIME));
				//构造任务数据
				data=new PCData(count.incrementAndGet());
				System.out.println(data+" is put into queue");
				//将元素加入队列，2秒后还没加入就放弃
				if(!queue.offer(data, 2, TimeUnit.SECONDS)){
					System.out.println("failed to put data: "+data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	public void stop(){
		isRunning=false;
	}
	
}

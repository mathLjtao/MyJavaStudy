package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.f_producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	public static void main(String[] args) throws Exception {
		BlockingQueue<PCData> queue =new LinkedBlockingDeque<PCData>();
		Producer p1=new Producer(queue);
		Producer p2=new Producer(queue);
		Producer p3=new Producer(queue);
		
		Consumer c1=new Consumer(queue);
		Consumer c2=new Consumer(queue);
		Consumer c3=new Consumer(queue);
		//建立线程池
		ExecutorService service=Executors.newCachedThreadPool();
		//运行生存者
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);
		Thread.sleep(3*1000);
		p1.stop();
		p2.stop();
		p3.stop();
		Thread.sleep(3*1000);
		c1.stop();
		c2.stop();
		c3.stop();
		service.shutdown();
	}
}

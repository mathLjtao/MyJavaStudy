package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.f_producer_consumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME=1000;
	private volatile boolean isRunning=true;
	public Consumer(BlockingQueue<PCData> queue){
		 this.queue=queue;
	}
	@Override
	public void run() {
		System.out.println("start Consumer id="+Thread.currentThread().getId());
		Random r= new Random();
		try {
			while(isRunning){
				PCData data=queue.take();
				if(data!=null){
					int re=data.getData()*data.getData();
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
					Thread.sleep(r.nextInt(SLEEPTIME));
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

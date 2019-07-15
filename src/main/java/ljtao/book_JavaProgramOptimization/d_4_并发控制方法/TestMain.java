package ljtao.book_JavaProgramOptimization.d_4_并发控制方法;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ljtao.book_JavaProgramOptimization.d_4_并发控制方法.a_volatile.MyThread;
import ljtao.book_JavaProgramOptimization.d_4_并发控制方法.a_volatile.VolatileTest;
import ljtao.book_JavaProgramOptimization.d_4_并发控制方法.b_synchronized.BlockQueue;

public class TestMain {
	//实现的阻塞队列对象
	static BlockQueue bq=new BlockQueue();
	public static void main(String[] args) throws Exception {
		//demo3();
	}
	//测试实现的阻塞队列BlockQueue
	private static  void demo3() throws Exception {
		//这里需要弄两个线程中做测试，要是只有一个线程的话，就会一直在执行pop()的等待
		new Thread(){
			public void run() {
				try {
					System.out.println(bq.pop());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		Thread.sleep(1000);
		new Thread(){
			public void run() {
				try {
					bq.put("hahah");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
	//测试使用了volatile关键字
	private static void demo2() {
		VolatileTest vt=new VolatileTest();
		System.out.println(vt.isExit);
		try {
			vt.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private static void demo1() {
		MyThread mt=new MyThread();
		new Thread(mt).start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mt.stop();
	}
	
}

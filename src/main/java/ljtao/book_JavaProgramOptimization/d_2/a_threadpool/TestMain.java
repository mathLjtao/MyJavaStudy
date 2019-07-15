package ljtao.book_JavaProgramOptimization.d_2.a_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/*
 * 线程池测试
 */
public class TestMain {
	public static void main(String[] args) throws Exception {
		demo3();
	}
	//不用线程池，开启多个线程的测试
	public static void demo1(){
		//MyThread mt=new MyThread("a1");
		for (int i = 0; i <1; i++) {
			new Thread(new MyThread("a"+i)).start();
		}
	}
	//用自己写的线程池，开启多个线程的测试
	public static void demo2() throws Exception{
		for (int i = 0; i <20; i++) {
			MyThreadPool.getInstance().start(new MyThread("a"+i));
			
		}
		MyThreadPool.getInstance().shutdown();
		for (int i = 10; i <20; i++) {
			//MyThreadPool.getInstance().start(new MyThread("a"+i));
		}
	}
	/*
	 * 用JDK自带的线程池，开启多个线程测试
	 * Executors类扮演着线程池工厂的角色。
	 * 以前也学过这个，但是印象不深刻，也不知道它的用处。现在知道对象池是什么概念，学起来就容易多了。知识都是一步步累计起来的，不是一下子就会的。
	 */
	public static void demo3(){
		//返回一个可根据实际情况调整线程数量的线程池。
		ExecutorService exe = Executors.newCachedThreadPool();
		/*
		Executors还可返回其他用处的线程池,有以下这些，用处的话可以查JDK文档就知道了
		Executors.newFixedThreadPool(5);
		Executors.newSingleThreadExecutor();
		Executors.newScheduledThreadPool(5);
		Executors.newSingleThreadScheduledExecutor();
		//返回一个可在多久之后执行，或周期执行的线程池，线程池大小固定为1
		ScheduledExecutorService sexe2 = Executors.newSingleThreadScheduledExecutor();
		 */
		
		for (int i = 0; i < 10; i++) {
			//在线程池中执行一个任务
			exe.execute(new MyThread("testJDKThreadPool "+i));
		}
		exe.shutdown();
		
	}
}

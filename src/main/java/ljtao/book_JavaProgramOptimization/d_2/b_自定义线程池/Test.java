package ljtao.book_JavaProgramOptimization.d_2.b_自定义线程池;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		demo1();
	}
	/*
	 * 测试一个 （线程池的线程被占满了），线程池（ExecutorService）会 先执行优先级较高的线程任务。
	 * (就是系统资源紧张时（线程池中的数量不足），程序总是根据任务优先级，处理优先级高的任务)
	 * 使用优先队列时，任务线程必须实现Comparable接口，优先队列会根据该接口对任务进行排列.
	 */
	private static void demo1() {
		ExecutorService exe=new ThreadPoolExecutor(10, 20, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		for (int i = 30; i >0 ; i--) {
			exe.execute(new MyThread("TestThreadPoolExecutor3_"+Integer.toString(i)));
		}
		exe.shutdown();
		
	}
}

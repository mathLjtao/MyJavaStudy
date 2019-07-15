package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.d_ThreadLocal;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		//弄三个线程运行
		exe.submit(new MyThread(new Date().getTime()));
		exe.submit(new MyThread(new Date().getTime()));
		exe.submit(new MyThread(new Date().getTime()));
		exe.shutdown();
	}
}

package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.c_lock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Semaphore，读[ˈseməfɔ:(r)]，是计数信号量。Semaphore管理一系列许可证。每个acquire方法阻塞，直到有一个许可证可以获得然后拿走一个许可证；
 * 每个release方法增加一个许可证，这可能会释放一个阻塞的acquire方法。简单的用法如下所示：
 * 1、用处：可以指定多少个线程同时访问某一个资源（这个数量可以自己决定）
 * 
 */
public class TestSemaphore {
	public static void main(String[] args) {
		SemaphoreDemo sd=new SemaphoreDemo();
		ExecutorService exe = Executors.newCachedThreadPool();
		//
		exe.submit(sd.new Task("a"));
		exe.submit(sd.new Task("b"));
		exe.submit(sd.new Task("c"));
		exe.submit(sd.new Task("d"));
		exe.submit(sd.new Task("e"));
		exe.submit(sd.new Task("f"));
		exe.submit(sd.new Task("g"));
		exe.submit(sd.new Task("h"));
		exe.submit(sd.new Task("i"));
		exe.shutdown();
	}
}

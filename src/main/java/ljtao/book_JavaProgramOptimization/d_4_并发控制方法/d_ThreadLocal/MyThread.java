package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.d_ThreadLocal;

import java.util.Date;
/*
 * https://www.cnblogs.com/mathlin/articles/10874553.html
 * 博客有更多对ThreadLocal的介绍
 * 或者可以看 ThreadLocal 的get()方法，理清它的数据结构
 */
public class MyThread implements Runnable{
	//创建一个固定的线程本地对象
	public final static ThreadLocal<Date> local=new  ThreadLocal<Date>();
	private long time;
	MyThread(long time){
		this.time=time;
	}
	@Override
	public void run() {
		//每个线程中独立的变量
		Date date=new Date(time);
		local.set(date);
		System.out.println("id="+time+",local="+local.get().getTime());
		for (int i = 0; i < 5000; i++) {
			if(time!=local.get().getTime()){
				System.out.println("id="+time+",local="+local.get().getTime());
			}
		}
	}

}

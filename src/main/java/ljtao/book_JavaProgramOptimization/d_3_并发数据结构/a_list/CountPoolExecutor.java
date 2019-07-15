package ljtao.book_JavaProgramOptimization.d_3_并发数据结构.a_list;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPoolExecutor extends ThreadPoolExecutor{
	private static final int TASK_COUNT = 400;
	//统计执行此时
	private AtomicInteger count=new AtomicInteger(0);
	public long startTime=0;
	public String funcname="";
	public CountPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	protected void afterExecute(Runnable r,Throwable t){
		//每次执行一个任务就加1
		int l=count.addAndGet(1);
		if(l==TASK_COUNT){
			System.out.println(funcname+"spend time:"+(System.currentTimeMillis()-startTime));
		}
	}

}

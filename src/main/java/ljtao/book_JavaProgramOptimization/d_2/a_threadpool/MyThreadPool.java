package ljtao.book_JavaProgramOptimization.d_2.a_threadpool;

import java.util.List;
import java.util.Vector;

/*
 * 线程池的基本功能就是进行线程的复用，为了节省系统在多线程并发是不断创建和销毁线程所带来的额外开销。
 * 自己实现的线程池，有点不稳定，还是用JDK自带的好
 */
public class MyThreadPool {
	private static MyThreadPool instance=null;
	//空闲的线程队列
	private List<PThread> idleThreads;
	//已有的线程总数
	private int threadCounter;
	private boolean isShutDown=false;
	private MyThreadPool(){
		this.idleThreads=new Vector(3);
		threadCounter=0;
	}
	public int getCreatedThreadsCount(){
		return threadCounter;
	}
	//取得线程池的实例
	public synchronized static  MyThreadPool getInstance(){
		if(instance==null){
			instance=new MyThreadPool();
		}
		return instance;
	}
	//将线程放入到池中
	public synchronized void repool(PThread repooolingThread){
		if(!isShutDown){
			idleThreads.add(repooolingThread);
		}
		else{
			repooolingThread.shutDown();
		}
	}
	//停止池中所有线程
	public synchronized void shutdown(){
		isShutDown=true;
		for (int i = 0; i < idleThreads.size(); i++) {
			PThread idleThread=(PThread)idleThreads.get(i);
			idleThread.shutDown();
		}
	}
	//执行任务
	public synchronized void start(Runnable target){
		PThread thread=null;
		//有空闲线程，直接使用
		if(idleThreads.size()>0){
			int lastIndex=idleThreads.size()-1;
			thread=(PThread)idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			//立即执行这个任务
			thread.setTarget(target);
			System.out.print("有");
		}
		//没有空闲线程，则创建新县城
		else{
			threadCounter++;
			//创建新线程, ---这里有疑问
			thread=new PThread(target,"PThread #"+threadCounter,this);
			//启动这个线程
			thread.start();
		}
	}
	
}

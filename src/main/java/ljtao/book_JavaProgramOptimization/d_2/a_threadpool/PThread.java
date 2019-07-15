package ljtao.book_JavaProgramOptimization.d_2.a_threadpool;

public class PThread extends Thread{
	//线程池
	private MyThreadPool pool;
	//任务
	private Runnable target;
	private boolean isShutDown=false;
	private boolean isIdle=false;

	public PThread(Runnable target, String name, MyThreadPool pool) {
		super(name);
		this.pool=pool;
		this.target=target;
	}
	public Runnable getTarget(){
		return target;
	}
	public boolean isIdle(){
		return isIdle;
	}
	public void run(){
		while(!isShutDown){
			isIdle=false;
			//这里有问题？？？？
			if(target!=null){
				target.run();
			}
			//任务结束了，到闲置状态
			isIdle=true;
			
			try {
				pool.repool(this);
				synchronized(this){
					//线程空闲，等待新的任务到来
					wait();
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isIdle=false;
			
		}
	}
	public synchronized void setTarget(Runnable newTarget) {
		target=newTarget;
		//设置了任务之后，通知run方法，开始执行这个任务，使在wait的线程开始执行
		notifyAll();
		
	}
	//关闭线程
	public synchronized void shutDown(){
		isShutDown=true;
		notifyAll();
	}
}

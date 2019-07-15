package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.c_master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/*
 * master-worker模式 核心思想
 * 系统由两类进程协作：master进程负责接收和分配任务（放子任务队列Queue、结果集Map），worker进程负责处理子任务（从任务队列中获取子任务），
 * 当各个worker进程将子任务处理完成后，将结果返回给Master进程(放进结果集Map中)，
 * 由Master进程做归纳和汇总，从而得到系统的最终结果
 * 
 */
//用于任务的分配和最终结果的合成
public class Master {
	//任务队列
	protected Queue<Object> workQueue=new ConcurrentLinkedQueue<Object>();
	//Worker进程队列
	protected Map<String,Thread> threadMap=new HashMap<>();
	//子任务处理结果集
	protected Map<String,Object> resultMap =new ConcurrentHashMap<String, Object>();
	//是否所有的子任务都处理完
	public boolean isComplete(){
		for(Map.Entry<String, Thread> entry:threadMap.entrySet()){
			//Thread.State.TERMINATED 终止线程的线程状态。 线程已完成执行。 
			if(entry.getValue().getState()!=Thread.State.TERMINATED)
				return false;
		}
		return true;
	}
	//master的构造，需要一个worker进程逻辑，跟需要worker进程的数量
	public Master(Worker worker,int count){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for (int i = 0; i < count; i++) {
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	//提交一个任务
	public void submit(Object job){
		workQueue.add(job);
	}
	//返回结果集
	public Map<String,Object> getResult(){
		return resultMap;
	}
	//运行所有worker进程
	public void execute(){
		for(Map.Entry<String, Thread> entry:threadMap.entrySet()){
			entry.getValue().start();
		}
	}
}

package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.c_master_worker;

import java.util.Map;
import java.util.Queue;

//用于实际处理一个任务
public class Worker implements Runnable{
	private Queue<Object> workQueue;
	private Map<String, Object> resultMap;
	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue=workQueue;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap=resultMap;
	}
	//实现具体逻辑处理
	public Object handle(Object input){
		int i=(int)input;
		return i*i*i;
	}
	@Override
	public void run() {
		while(true){
			//获取子任务
			Object input = workQueue.poll();
			if(input==null)
				break;
			//处理子任务
			Object re=handle(input);
			//将结果写入到结果集中
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}

	

}

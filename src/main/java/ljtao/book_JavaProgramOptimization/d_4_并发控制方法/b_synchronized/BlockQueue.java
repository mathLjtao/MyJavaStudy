package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.b_synchronized;

import java.util.ArrayList;
import java.util.List;

/*
 * 实现一个阻塞队列
 * 1、有pop()跟put()方法
 * 2、pop()取出队列中的一个值，队列没有值的话就等待
 * 3、put()往队列里面加入一个值，并通知等待中的pop方法
 */
public class BlockQueue {
	List<String> list;
	public BlockQueue(){
		list=new ArrayList<>();
	}
	public synchronized String pop() throws Exception {
		while(list.size()==0)
			this.wait();
		if(list.size()>0){
			return list.remove(0);
		}
		else{
			return null;
		}
		
	}
	public synchronized void put(String s) throws Exception{
		list.add(s);
		this.notify();
	}
}

package ljtao.book_JavaProgramOptimization.d_3_并发数据结构.a_list;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccessListThread implements Runnable{
	
	protected String name;
	private CopyOnWriteArrayList list;
	private Vector vlist;
	Random rand=new Random();
	public AccessListThread(){
	}
	public AccessListThread(String name,CopyOnWriteArrayList list){
		this.name=name;
		this.list=list;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				
				getList(rand.nextInt(100));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private Object getList(int index){
		return list.get(index);
	}
}

package ljtao.pattern.a_singleton;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static List<Singleton> sarr=new ArrayList<Singleton>();
	
	public static void main(String[] args) {
		 
		for(int i=0;i<10;i++) {
			new Thread("线程"+i+":") {
				public void run() {
					Singleton singleton=Singleton.getSingleton();
					 sarr.add(singleton);
					//由下可以看出，不同线程获得的对象都是一样的
					System.out.println(this.currentThread().getName()+this+"，singleton对象："+singleton);
				}
			}.start();
		}
		
		try {
			Thread.sleep(2000);
			System.out.println(sarr.get(1)==sarr.get(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

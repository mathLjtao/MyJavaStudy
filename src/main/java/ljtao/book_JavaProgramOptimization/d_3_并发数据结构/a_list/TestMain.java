package ljtao.book_JavaProgramOptimization.d_3_并发数据结构.a_list;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestMain {
	public static void main(String[] args) {
		demo2();
	}
	//多线程测试ConcurrentHashMap
	private static void demo2() {
		ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
		map.put("1", "aa");
	}
	//多线程测试并发list
	private static void demo1() {
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		long startTime=System.currentTimeMillis();
		String funcname="Test:";
		CountPoolExecutor exe = new CountPoolExecutor(200, 400, 0l,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		exe.funcname=funcname;		
		exe.startTime=startTime;
		for (int i = 0; i < 400; i++) {
			exe.submit(new AccessListThread("a"+i,list));
		}
		exe.shutdown();
	}
	
}

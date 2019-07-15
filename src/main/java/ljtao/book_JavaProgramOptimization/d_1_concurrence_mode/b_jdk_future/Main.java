package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.b_jdk_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {
	public static void main(String[] args) throws Exception {
		FutureTask<String> ft=new FutureTask<>(new RealData("a"));
		ExecutorService es=Executors.newFixedThreadPool(1);
		//执行FutureTask，相当于自己写的例子中的client.request("a") 发送请求
		//在这里开启线程进行RealData的call()执行
		es.submit(ft);
		System.out.println("请求完毕");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//取得call()的返回值
		//如果此时call()方法没有执行完成，则依然会等待
		System.out.println("数据="+ft.get());
	}
}

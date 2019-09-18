package ljtao.javase.thread.callable.ex1_simple;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainExe {
    public static void main(String[] args) throws  Exception{
        demo1();
    }
    //测试有返回值的线程
    public static void demo1() throws  Exception{
        ExecutorService es = Executors.newFixedThreadPool(5);
        Callable c1 = new MyCallable("MyCallable");
        Callable c2 = new ApproveCallable("ApproveCallable");
        Future submit1 = es.submit(c1);
        Map<String,String> reHm1 = (Map<String,String>)submit1.get();
        System.out.println(reHm1);
        Future submit2 = es.submit(c2);
        Map<String,String> reHm2 = (Map<String,String>)submit2.get();
        System.out.println(reHm2);

        //测试调用3秒后才执行完成的数据
        Callable c3 = new MyCallable(reHm2.get("name"));
        Future submit3 = es.submit(c3);
        Map<String,String> reHm3 = (Map<String,String>)submit3.get();
        System.out.println(reHm3);
        es.shutdown();
    }
}

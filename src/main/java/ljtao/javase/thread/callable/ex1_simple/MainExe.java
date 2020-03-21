package ljtao.javase.thread.callable.ex1_simple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class MainExe {
    public static void main(String[] args) throws  Exception{
        demo2();
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
    //另一些写法
    public static void demo2() throws Exception{
        FutureTask<Map<String,String>> futureTask1=new FutureTask<Map<String,String>>(()->{
            Map<String,String> reHm=new HashMap<>();
            reHm.put("a","table");
            reHm.put("b","div");
            reHm.put("c","span");
            return reHm;
        });
        new Thread(futureTask1).start();


        Callable c1 = new MyCallable("MyCallable");
        FutureTask<Map<String,String>> futureTask2=new FutureTask<Map<String,String>>(c1);
        new Thread(futureTask2).start();

        System.out.println(futureTask1.get());//会等待任务执行结束
        System.out.println(futureTask2.get());

    }
}

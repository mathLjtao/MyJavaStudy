package ljtao.javase.thread.threadpool.jdk_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsFactory {
    private static ExecutorService es=null;
    public static void main(String[] args) {
        ExecutorsFactory ef=new ExecutorsFactory();
        //ef.newFixedThreadpool();
        ef.newCachedThreadPool();
        if(es!=null)
            es.shutdown();
    }
    public  void newFixedThreadpool(){
        //运用ThreadPoolExecutor类，不懂就看源码，去了解ThreadPoolExecutor类
        /*
        每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，
        如果某个线程因为执行异常而结束，那么线程池会补充一个新线程线。
         */
        es= Executors.newFixedThreadPool(5);
        for (int i=0;i<10;i++){
            es.submit(new MyThread());
        }
    }
    public void newSingleThreadExecutor(){
        //线程池只有一个线程。线程池保证所有任务的执行顺序按照任务的提交顺序执行。
        es=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            es.submit(new MyThread());
        }
    }
    public void newScheduledThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(6);
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.submit(new MyThread());
        }
        System.out.println("最后两个线程，都是延迟3秒后执行...");
        scheduledExecutorService.schedule(new MyThread(),3000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(new MyThread(),3000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.shutdown();
    }
    /*
    可缓存的线程池：如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
    此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
    官方建议程序员使用较为方便的Executors工厂方法Executors.newCachedThreadPool()（无界线程池，可以进行自动线程回收）
     */
    public void newCachedThreadPool(){
        //线程池中的线程无边界
        es = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            es.submit(new MyThread());
        }
    }
}

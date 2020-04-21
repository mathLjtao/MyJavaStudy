package ljtao.javase.thread.callable.ex2;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ljtao
 * @date 2020/3/21
 */
public class MyFutureTask<T> implements Runnable, Future {
    private Callable callable;//业务逻辑在callable里面
    private LinkedBlockingQueue<Thread> workQueue=new LinkedBlockingQueue();//定义一个存储等待者的队列
    private volatile String status="start";//task执行状态
    private T result=null;
    public MyFutureTask(Callable callable){
        this.callable=callable;
    }

    @Override
    public void run() {
        try {
            result = (T) callable.call();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            status="end";
        }
        Thread thread ;
        while ((thread= workQueue.poll())!=null){
            LockSupport.unpark(thread);
        }

    }

    //get方法这里有个线程的通信
    @Override
    public Object get() throws InterruptedException, ExecutionException {
        System.out.println(status);
        if ("end".equals(status)){
            return result;
        }
        else {
            while (!"end".equals(status)){
                System.out.println(Thread.currentThread().getName());
                //TODO 这里还需要加上代码。判断，队列有没有这个线程，没有的话要加上.这样严谨一点
                if(!workQueue.contains(Thread.currentThread())){
                    workQueue.put(Thread.currentThread());//如果结果还没出来，加入到等待队列，线程不往下执行
                    System.out.println(workQueue.size());
                }
                LockSupport.park();
            }
        }
        return result;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }



    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}

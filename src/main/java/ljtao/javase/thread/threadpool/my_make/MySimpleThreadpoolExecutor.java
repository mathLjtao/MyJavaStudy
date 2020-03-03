package ljtao.javase.thread.threadpool.my_make;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljtao3 on 2020/3/3
 */
public class MySimpleThreadpoolExecutor implements MyExecutorService {

    public int size;
    public int maxSize;
    public BlockingQueue<Runnable> workQueue;
    private final ReentrantLock  mainLock= new ReentrantLock();

    public MySimpleThreadpoolExecutor(int size, int maxSize, BlockingQueue<Runnable> workQueue)  {
        if(size<0 || maxSize <=0 || maxSize<size){
            throw new IllegalArgumentException("线程数量设置错误");
        }
        this.size=size;
        this.maxSize=maxSize;
        this.workQueue=workQueue;

        if(workQueue ==null){
            throw new NullPointerException();
        }


        for(int i=0;i<size ;i++){
            new Worker().start();
        }
    }







    @Override
    public void execute(Runnable task) {
        workQueue.add(task);
    }

    @Override
    public void shutdown() {
        final ReentrantLock lock=this.mainLock;
        lock.lock();
        try{

        }finally{
            lock.unlock();
        }

    }

    private class Worker extends Thread{

        final  ReentrantLock lock=mainLock;

        @Override
        public void run(){
            while(true ){
                if (!workQueue.isEmpty()){
                    Runnable r = workQueue.poll();
                    if(r!=null){
                        r.run();
                    }
                }

            }
        }
    }
}

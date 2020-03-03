package ljtao.javase.thread.threadpool.my_make;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljtao3 on 2020/3/3
 */
public class MyThreadpoolExecutor implements MyExecutorService {

    private AtomicInteger ctl=new AtomicInteger();
    private volatile boolean isShutDown=false;
    private final HashSet<Worker> workers = new HashSet<>();
    public int size;
    public int maxSize;
    public BlockingQueue<Runnable> workQueue;
    private final ReentrantLock  mainLock= new ReentrantLock();

    public MyThreadpoolExecutor(int size, int maxSize, BlockingQueue<Runnable> workQueue)  {
        if(size<0 || maxSize <=0 || maxSize<size){
            throw new IllegalArgumentException("线程数量设置错误");
        }
        this.size=size;
        this.maxSize=maxSize;
        this.workQueue=workQueue;

        if(workQueue ==null){
            throw new NullPointerException();
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

    public boolean addWorker(Runnable r,boolean startNew){
        if(startNew){
            ctl.incrementAndGet();
        }
        boolean workerAdded=false;
        boolean workerStarted=false;
        Worker w=new Worker(r);
        Thread t=w.thread;
        if(t!=null){
            ReentrantLock mainLock=this.mainLock;
            mainLock.lock();
            try{
                if(!isShutDown){
                    //检查线程是否已经处于运行状态，start()方法不能重复调用
                    if(t.isAlive())
                        throw  new IllegalThreadStateException();
                    workers.add(w);
                    workerAdded=true;
                }
            }finally {
                mainLock.unlock();
            }
            if(workerAdded){
                t.start();
                workerStarted=true;
            }
        }
        return workerStarted;

    }


    public void runWorker(Worker  w){
        Thread wt = Thread.currentThread();
        Runnable task = w.firstTask;
        w.firstTask=null;
        boolean completedAbruptly = true;
        try{
            while(task !=null || (task =getTask())!=null){
                w.lock();
                if(isShutDown && !wt.isInterrupted()){
                    wt.interrupt();
                }
                try{
                    task.run();
                }
                finally {
                    task=null;
                    w.completedTask++;
                    w.unlock();
                }
            }
            completedAbruptly=false;
        }
        finally {

        }
    }

    private  Runnable getTask(){
        return workQueue.poll();
    }

    static AtomicInteger atomic =new AtomicInteger();

    private class Worker extends ReentrantLock implements Runnable{

        volatile long completedTask;//当前线程池完成的数量数

        final Thread thread;
        Runnable firstTask;

        public Worker (Runnable firstTask ){
            this.firstTask=firstTask;
            thread =new Thread(this,"Thread-name- "+ atomic.incrementAndGet());
        }
        @Override
        public void run(){
            runWorker(this);
        }
    }
}

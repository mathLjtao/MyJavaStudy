package ljtao.javase.thread.threadpool.my_make;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ljtao3 on 2020/3/3
 */
public class Test {
    public static void main(String[] args) throws Exception {
        fun1();
    }

    /*
    测试自制的简单线程池
     */
    public static void fun1() throws Exception {
        MyExecutorService es=new MySimpleThreadpoolExecutor(3,4,new LinkedBlockingQueue<>());
        MyTask t1=new MyTask(1);
        MyTask t2=new MyTask(2);
        MyTask t3=new MyTask(3);
        MyTask t4=new MyTask(4);
        MyTask t5=new MyTask(5);
        MyTask t6=new MyTask(6);
        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);
        es.execute(t6);
        for(int i=10;i<20;i++){
            es.execute(new MyTask(i));
        }

    }
}

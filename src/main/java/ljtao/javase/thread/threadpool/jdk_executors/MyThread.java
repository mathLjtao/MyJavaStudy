package ljtao.javase.thread.threadpool.jdk_executors;

public class MyThread extends Thread {

    public void run(){
        System.out.println(Thread.currentThread().getName()+"：正在执行");
    }
}

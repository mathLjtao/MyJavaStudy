package ljtao.javase.thread.lock.reentranlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljtao3 on 2020/3/9
 *
 * ReentranLock 锁过程原理
 * 未锁(ReentranLock)  持有者（null,计数（0））
 * --》  锁(ReentranLock)  持有者（线程2,计数（1））
 * --》  锁(ReentranLock)  持有者（线程2,计数（2））
 * --》  解锁(ReentranLock)  持有者（线程2,计数（1））
 * --》  解锁(ReentranLock)  持有者（null,计数（0））
 *
 *
 */
public class Demo1 {
    private final static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        //new Demo1().fun1();
        new Demo1().fun2();
    }

    //演示多次获取锁、可重入，没有释放完全
    public void fun1(){

        lock.lock();
        try{
            System.out.println("第一次获取的锁");
            System.out.println("当前线程获取锁的次数："+lock.getHoldCount());
            lock.lock();
            System.out.println("第二次获取的锁");
            System.out.println("当前线程获取锁的次数："+lock.getHoldCount());

        }finally {
            lock.unlock();

        }

        System.out.println("当前线程获取锁的次数："+lock.getHoldCount());
        //如果不释放 锁，此时其他线程是拿不到锁的
         new Thread(()->{
             System.out.println(Thread.currentThread()+" ：期望抢到锁");
             lock.lock();
             System.out.println(Thread.currentThread()+"：线程拿到了锁");
         }).start();
    }

    //演示多次获取锁，锁完全释放
    public void fun2(){

        lock.lock();
        try{
            System.out.println("第一次获取的锁");
            System.out.println("当前线程获取锁的次数："+lock.getHoldCount());
            lock.lock();
            System.out.println("第二次获取的锁");
            System.out.println("当前线程获取锁的次数："+lock.getHoldCount());

        }finally {
            //lock了两次，unlock也需要执行两次，程序才正常
            lock.unlock();
            lock.unlock();
        }

        System.out.println("当前线程获取锁的次数："+lock.getHoldCount());
        //如果不释放 锁，此时其他线程是拿不到锁的
        new Thread(()->{
            System.out.println(Thread.currentThread()+" ：期望抢到锁");
            lock.lock();
            System.out.println(Thread.currentThread()+"：线程拿到了锁");
        }).start();
    }

}

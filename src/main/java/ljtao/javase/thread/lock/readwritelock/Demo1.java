package ljtao.javase.thread.lock.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ljtao3 on 2020/3/9
 *
 * ReadWriteLock
 * 维护一对关联锁，一个用于只读操作，一个用于写入；读锁可以由多个读线程同时持有，写锁是排他的。
 *
 */
public class Demo1 {
    private final static ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private final static Lock  readLock=lock.readLock();
    private final static Lock writeLock=lock.writeLock();

    public static void main(String[] args) {
        //new Demo1().fun1();
        //new Demo1().fun2();
        new Demo1().fun3();
    }
    /*
        测试单个线程能不能先拥有写锁，然后再拥有读锁。
        结论：可以。
        因为拥有写锁，说明是线程安全的，只有一个线程在对资源进行操作，在这个线程中，可以再拥有读锁。
    */
    private void fun2() {
        new Thread(()->{

            System.out.println("开始获取写锁");
            writeLock.lock();
            try {
                System.out.println("对资源进行修改！！！！");
                System.out.println("开始获取读锁");
                readLock.lock();
                System.out.println("对资源进行访问！！！！");
            }finally {
                writeLock.unlock();
                System.out.println("写锁释放");
                readLock.unlock();
                System.out.println("读锁释放");
            }
        }).start();
    }
    /*
        测试单个线程能不能先拥有读锁，然后再拥有写锁。
        结论：不可以。
        因为拥有读锁，有多个线程在对资源进行访问操作，在某个线程中，如果拥有写锁，进行改写资源操作，会影响到其他拥有读锁的线程。
     */
    public void fun3(){
        System.out.println("开始获取读锁");
        readLock.lock();
        try{
            System.out.println("开始获取写锁");
            writeLock.lock();//这里会阻塞，处于一直等待的状态，要等到读锁释放才能运行。
        }finally {
            readLock.unlock();
            System.out.println("读锁释放");
            writeLock.unlock();
            System.out.println("写锁释放");
        }
    }


    /*
        "写锁"锁住的话 ，其他线程（其它想拥有读、写锁的线程）阻塞。
        "读锁"锁住的话，其他读锁线程还是能运行的。
     */
    public void fun1() {

        new Thread(()->{
            writeLock.lock();
            try{
                System.out.println("start write thread 0 ");
                Thread.sleep(1000);
                System.out.println("end write thread 0");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }).start();

        new Thread(()->{
            readLock.lock();
            try{
                System.out.println("start read thread 1");
                Thread.sleep(1000);
                System.out.println("end read thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }).start();


        new Thread(()->{
            readLock.lock();
            try{
                System.out.println("start read thread 2");
                Thread.sleep(1000);
                System.out.println("end read thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }).start();

        new Thread(()->{
            readLock.lock();
            try{
                System.out.println("start read thread 3 ");
                Thread.sleep(1000);
                System.out.println("end read thread 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }).start();

        new Thread(()->{
            writeLock.lock();
            try{
                System.out.println("start write thread 1 ");
                Thread.sleep(1000);
                System.out.println("end write thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }).start();

        new Thread(()->{
            writeLock.lock();
            try{
                System.out.println("start write thread 2 ");
                Thread.sleep(1000);
                System.out.println("end write thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }).start();


    }
}

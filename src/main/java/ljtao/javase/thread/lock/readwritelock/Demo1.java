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
        new Demo1().fun1();
    }
    /*
        "写锁"锁住的话 ，其他线程阻塞。
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

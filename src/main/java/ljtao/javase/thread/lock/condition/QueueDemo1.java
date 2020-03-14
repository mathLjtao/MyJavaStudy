package ljtao.javase.thread.lock.condition;

import ljtao.book_study.head_first_design_patterns.c_decorator.mycode.CondimentDecorator;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljtao3 on 2020/3/10
 *
 * condition  用于代替wait、notify
 * Object中的wait(),notify().notifyAll()方法是和synchronized配合使用的。可以唤醒一个或者全部（单个等待集）。
 * condition是需要与lock配合使用的，提供多个等待集合，更精确的控制（底层是park、unpark机制）
 *
 * 经典场景：JDK中的队列实现
 * 多线程读写队列，写入数据时，唤醒读取线程继续执行；读取数据后，通知写入队列继续执行。
 * 如果队列数组存满了，存数据方法先进入等待（阻塞）状态，等待其它线程拿取队列的数据，然后被唤醒。
 * 如果是队列为空，拿数据方法进入等待（阻塞）状态，等待其它线程存入数据到队列，然后被唤醒
 */
//实现队列线性安全
public class QueueDemo1 {
    final Lock lock=new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] arr=new Object[100];
    int count,puter,taker;

    public static void main(String[] args) throws Exception {
        //new QueueDemo1().fun1();
        new QueueDemo1().fun2();



    }
    /*
    多个线程测试
     */
    private void fun2() throws InterruptedException {
        QueueDemo1 queueDemo1 = new QueueDemo1();
        queueDemo1.count=0;
        queueDemo1.puter=0;
        queueDemo1.taker=0;
        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            new Thread(()->{
                for (int j = 0; j < 12; j++) {
                    queueDemo1.put(finalI*10+j);
                }
            }).start();
        }

        Thread.sleep(1000);

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(Thread.currentThread().getName()+":"+queueDemo1.take());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /*
    测试1
     */
    public void fun1(){
        QueueDemo1 queueDemo1 = new QueueDemo1();
        queueDemo1.count=0;
        queueDemo1.puter=0;
        queueDemo1.taker=0;

        new Thread(()->{
            queueDemo1.put(1);
            for (int j = 0; j < 102; j++) {
                queueDemo1.put(j);
            }
            //上面的循环超过100次，就不要输出end，除非还有线程继续拿arr数组里面的数据
            System.out.println("end");
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                System.out.println(queueDemo1.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    //写入数据
    public void put(Object x){
        lock.lock();
        try {
            while(count>=arr.length){
                //数组满了，进入等待，等其他线程拿取arr的数据后，然后被唤醒
                notFull.await();//不是wait方法，要不然会报错
            }
            arr[puter]=x;
            if(++puter>=arr.length){
                puter=0;
            }
            count++;
            notEmpty.signal();//唤醒指定获取数据的线程
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    //获取数据
    public Object take() throws Exception {
        lock.lock();
        try{
            while(count<=0){
                //没有元素了，进入等待，等其他线程存入数据到arr后，然后被唤醒
                notEmpty.await();
            }
            Object obj=arr[taker];
            if(++taker==arr.length){
                taker=0;
            }
            count--;
            notFull.signal();//唤醒指定存入数据的线程
            return obj;
        }
        finally {
            lock.unlock();
        }
    }

}

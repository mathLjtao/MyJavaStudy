package ljtao.javase.thread.basic;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author ljtao3 on 2020/4/20
 *
 * 测试线程的通信 sleep/wait/yield/join的区别
 */
public class MethodDemo {
    private static Object object=new Object();
    private static int i=0;
    public static void main(String[] args) throws Exception {
        MethodDemo methodDemo = new MethodDemo();


        Thread t2=new Thread(()->{
            try {
                //Thread.sleep(100);
                methodDemo.fun2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        Thread t1=new Thread(()->{
            try {
                ++i;
                //Thread.sleep(100);
                methodDemo.fun2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        t1.join();
        System.out.println("主线程的执行");

    }
    /*
        sleep 线程休眠，没有释放锁
     */
    @Test
    void fun1() throws InterruptedException {
        Thread.sleep(1000);
    }
    /*
    wait
在其他线程调用对象的notify或notifyAll方法前，导致当前线程等待。线程会释放掉它所占有的“锁标志”，从而使别的线程有机会抢占该锁。
当前线程必须拥有当前对象锁。如果当前线程不是此锁的拥有者，会抛出IllegalMonitorStateException异常。
唤醒当前对象锁的等待线程使用notify或notifyAll方法，也必须拥有相同的对象锁，否则也会抛出IllegalMonitorStateException异常。
waite()和notify()必须在synchronized函数或synchronized　block中进行调用。如果在non-synchronized函数或non-synchronized　block中进行调用，虽然能编译通过，但在运行时会发生IllegalMonitorStateException的异常。
     */
    public synchronized void fun2() throws InterruptedException {
        System.out.println(i);
        if (i==0){
            System.out.println("start wait------");
            System.out.println(Thread.currentThread().getName());
            //Thread.sleep(100);
            //Thread.yield();
            wait();
            System.out.println("end ");
        }
        else{
            notify();
            //notifyAll();
        }
    }

    /*
    暂停当前正在执行的线程对象。
yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
yield()只能使同优先级或更高优先级的线程有执行的机会。
调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的。
     */
    /*
    join方法
等待该线程终止。
等待调用join方法的线程结束，再继续执行。如：t.join();//主要用于等待t线程运行结束，若无此句，main则会执行完毕，导致结果不可预测。
在很多情况下，主线程创建并启动了线程，如果子线程中药进行大量耗时运算，主线程往往将早于子线程结束之前结束。
这时，如果主线程想等待子线程执行完成之后再结束，比如子线程处理一个数据，主线程要取得这个数据中的值，就要用到join()方法了。方法join()的作用是等待线程对象销毁。
     */
}

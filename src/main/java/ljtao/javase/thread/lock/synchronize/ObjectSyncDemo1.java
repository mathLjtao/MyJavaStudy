package ljtao.javase.thread.lock.synchronize;

/**
 * @author ljtao3 on 2020/3/9
 */
public class ObjectSyncDemo1 {

    public static void main(String[] args) {
        //代码没有实现同步，因为test1()方法是对象锁，需要同一个对象，才能实现同步
//        new Thread(()->{
//            new ObjectSyncDemo1().test1();
//        }).start();
//        new Thread(()->{
//            new ObjectSyncDemo1().test1();
//        }).start();

        //同一个对象执行，能同步
//        ObjectSyncDemo1 objectSyncDemo1=new ObjectSyncDemo1();
//        new Thread(()->{
//            objectSyncDemo1.test1();
//        }).start();
//        new Thread(()->{
//            objectSyncDemo1.test1();
//        }).start();

        //方法加上static变成类锁，能同步
        new Thread(()->{
            ObjectSyncDemo1.test2();
        }).start();
        new Thread(()->{
            ObjectSyncDemo1.test2();
        }).start();

    }
    //对象锁
    public synchronized void test1() {
        System.out.println(Thread.currentThread()+" : 我开始执行！");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": 我结束执行！");

    }

    //类锁
    public synchronized static void test2() {
        System.out.println(Thread.currentThread()+" : 我开始执行！");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": 我结束执行！");

    }
}

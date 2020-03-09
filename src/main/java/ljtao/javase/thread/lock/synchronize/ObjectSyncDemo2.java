package ljtao.javase.thread.lock.synchronize;

/**
 * @author ljtao3 on 2020/3/9
 * 可重入演示
 */
public class ObjectSyncDemo2 {
    public static void main(String[] args) {
        new ObjectSyncDemo2().test1(new Object());
    }
    public synchronized void test1(Object object) {
        System.out.println(Thread.currentThread()+" : 我开始执行！");
        try {
            if(object!=null){
                test1(null);
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": 我结束执行！");

    }
}

package ljtao.book_study.JavaConcurrencyInPractice.my_code.chapter02;

/**
 * @author ljtao
 * @date 2020/1/30
 *
 * 测试sychf方法.
 */
public class SyncClass {
    public synchronized void fun1(){
        System.out.println("fun1:"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始调用fun2");
        //这里之所以可以调用fun2，是因为内置锁是可重入的。详见书本21页
        fun2();
        System.out.println("调用fun2结束");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    /**
        第一个线程进入fun1()还没执行完,第二个线程用原对象不能执行fun2()。
     */
    public synchronized void fun2() {
        System.out.println("fun2:"+Thread.currentThread().getName());
    }
}

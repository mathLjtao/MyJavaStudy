package ljtao.javase.thread.skill;

/**
 * @author ljtao3 on 2020/3/6
 */
public class ThreadLocalCode {
    /*
    线程封闭具体的体现有：ThreadLocal、局部变量

    ThreadLocal是一个线程级别变量，每个线程都有一个ThreadLocal，就是每个线程都有自己的独立的一个变量，
    竞争条件被彻底消除了，在并发模式下是绝对安全的变量。

    其实可以成JDK底层中有一个Map，这个Map为<Thread,T>类型,每个线程拿到自己的值

    局部变量：是指在每个线程中自己设置的局部变量。
    封闭在线程中。它位于执行线程的栈中，其他线程无法访问这个栈。
     */
    public static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        threadLocal.set("main 123");

        new ThreadLocalCode().fun1();
        System.out.println("main:"+threadLocal.get());

    }
    /*
        在不同线程中，对ThreadLocal设置值
     */
    public void fun1() throws Exception {

        new Thread(()->{
            System.out.println("()->:"+threadLocal.get());
            threadLocal.set("()->  456");
            System.out.println("()->:"+threadLocal.get());
        }).start();

        Thread.sleep(2000);
        System.out.println("fun1:"+threadLocal.get());
    }


}

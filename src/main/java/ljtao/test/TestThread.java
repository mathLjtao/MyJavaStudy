package ljtao.test;

/**
 * @author ljtao3 on 2020/3/6
 */
public class TestThread extends Thread{

    public static void main(String[] args) {
        TestThread tt=new TestThread();
        System.out.println("main:"+tt);
        tt.fun1();
    }

    public  void fun1(){
        new Thread(()->{
            //这里的是this为什么会指向主线程呢。？？？
            System.out.println("()->:"+this);
            System.out.println("()->:"+Thread.currentThread().getName());

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Runnable:"+this);
                System.out.println("new Runnable:"+Thread.currentThread().getName());
            }
        }).start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("new thread:"+this);
                System.out.println("new thread:"+Thread.currentThread().getName());
            }
        }.start();


        System.out.println("fun1():"+this);
        System.out.println("fun1():"+Thread.currentThread().getName());


        //System.out.println(this);
    }
    @Override
    public void run(){
        System.out.println(this);
    }
}

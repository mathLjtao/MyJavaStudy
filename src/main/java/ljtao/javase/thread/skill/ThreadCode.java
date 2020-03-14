package ljtao.javase.thread.skill;

import java.math.BigDecimal;

/**
 * 记录关于线程的一些优化技巧
 * @author ljtao3 on 2020/3/6
 */
public class ThreadCode {
    Object food=null;

    public static void main(String[] args) throws  Exception {
        new ThreadCode().fun1();
    }

    /*
        用while循环中检查等待条件
     */
    public void fun1() throws Exception{

        new Thread(()->{
            /*
            伪唤醒
            这里之所以用while循环中检查等待条件，是官方也建议这样做
            原因是处于等待状态的线程可能会收到错误警报和伪唤醒，
             */
            while(food ==null){
                synchronized (this){
                    System.out.println("没有食物，等待食物被生产！");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("拿到食物！");
        }).start();
        Thread.sleep(3000);
        food=new Object();
        System.out.println("食物生产完毕，通知消费者");
        synchronized (this){
            this.notifyAll();
        }
    }
}

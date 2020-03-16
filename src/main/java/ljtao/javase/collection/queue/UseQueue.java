package ljtao.javase.collection.queue;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ljtao
 * @date 2020/3/15
 */
public class UseQueue {


    public static void main(String[] args) throws InterruptedException {
        new UseQueue().fun1();
    }
    /*
        阻塞队列，底层是用数组来维护的。
        主要应用场景：jdk线程池
     */
    //test 存入数据跟取出数据
    public  void  fun1() throws InterruptedException {
        
        //可以选择是否需要公平
        ArrayBlockingQueue<String> abq=new ArrayBlockingQueue(3,false);

        new Thread(()->{
            while (true){
                try {
                    System.out.println("从队列获取到数据："+abq.poll());//poll非阻塞 取数据
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(3000);

        //多个线程塞数据
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                try {
//                    if(abq.offer(Thread.currentThread().getName())){ //存入数据，队列满了得话返回false
//                        System.out.println("存入数据成功！");
//                    }
//                    else {
//                        System.out.println("队列已满！");
//                    }
                    abq.put(Thread.currentThread().getName());//队列满了会阻塞
                    System.out.println("存入数据成功");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }



    }
}

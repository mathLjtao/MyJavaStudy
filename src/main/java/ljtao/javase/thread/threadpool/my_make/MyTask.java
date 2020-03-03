package ljtao.javase.thread.threadpool.my_make;

/**
 * @author ljtao3 on 2020/3/3
 */
public class MyTask implements Runnable {
    int i;
    public MyTask(int sum){
        i=sum;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+","+i+"，task running !");
    }
}

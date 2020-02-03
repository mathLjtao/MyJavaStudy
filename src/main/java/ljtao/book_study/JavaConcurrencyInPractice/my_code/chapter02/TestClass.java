package ljtao.book_study.JavaConcurrencyInPractice.my_code.chapter02;

/**
 * @author ljtao
 * @date 2020/1/30
 */
public class TestClass {
    public static void main(String[] args) throws Exception {
        System.out.println("ddddd");
        //new SyncClass().fun1();
        SyncClass sc=new SyncClass();
        new Thread(()->{
            sc.fun1();
        }).start();
        Thread.sleep(2000);
        new Thread(()->{
            sc.fun2();
        }).start();
    }
}

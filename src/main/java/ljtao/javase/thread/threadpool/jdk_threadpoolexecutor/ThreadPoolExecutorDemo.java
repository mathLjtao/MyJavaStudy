package ljtao.javase.thread.threadpool.jdk_threadpoolexecutor;

import ljtao.javase.thread.threadpool.jdk_executors.MyThread;

import java.util.concurrent.*;

/*
ThreadPoolExecutor 的一个构造方法
public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)
corePoolSize--池中所保存的线程数，包括空闲线程。
maximumPoolSize--池中允许的最大线程数。
keepAliveTime--当线程数大于corePoolSize时，此为终止空闲线程等待新任务的最长时间。
Unit--keepAliveTime 参数的时间单位。
workQueue--执行前用于保持任务的队列。此队列仅保持由 execute方法提交的 Runnable任务。
threadFactory--执行程序创建新线程时使用的工厂。
Handler--由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。

1)SynchronousQueue
该队列对应的就是上面所说的直接提交，首先SynchronousQueue是无界的，也就是说他存数任务的能力是没有限制的，但是由于该Queue本身的特性，在某次添加元素后必须等待其他线程取走后才能继续添加。
2)LinkedBlockingQueue
该队列对应的就是上面的无界队列。
3)ArrayBlockingQueue
该队列对应的就是上面的有界队列。ArrayBlockingQueue有以下3中构造方法：
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutorDemo demo=new ThreadPoolExecutorDemo();
        //demo.testSynchronousQueue();
        //demo.testLinkedBlockingQueue();
        demo.textArrayBlockingQueue();
    }
    /*
    直接提交：工作队列的默认选项是 SynchronousQueue，(首先SynchronousQueue是无界的，也就是说他存数任务的能力是没有限制的，
    但是由于该Queue本身的特性，在某次添加元素后必须等待其他线程取走后才能继续添加。)它将任务直接提交给线程而不保存它们。
    在此，如果不存在可用于立即运行任务的线程，则试图把任务加入队列将失败，因此会构造一个新的线程。
    此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。
    直接提交通常要求无界 maximumPoolSizes(线程池大小) 以避免拒绝新提交的任务。当边界受限，会报异常，有些任务不会被执行
    当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
     */
    public void testSynchronousQueue(){
        ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        ThreadPoolExecutor tp2 = new ThreadPoolExecutor(5, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        //如果线程池边界大小被限制，任务太多会报异常
        for (int i = 0; i < 20; i++) {
            //tp.submit(new MyThread());
        }
        //tp2边界足够大就不会报异常
        for (int i = 0; i < 200; i++) {
            tp2.submit(new MyThread());
        }
        tp.shutdown();
        tp2.shutdown();
    }
    /*
    无界队列：使用无界队列（例如，不具有预定义容量的 LinkedBlockingQueue）将导致在所有 corePoolSize 线程都忙时新任务在队列中等待。
    这样，创建的线程就不会超过 corePoolSize。（因此，maximumPoolSize的值也就无效了。）当每个任务完全独立于其他任务，
    即任务执行互不影响时，适合于使用无界队列；例如，在 Web页服务器中。这种排队可用于处理瞬态突发请求，
    当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
     */
    public void testLinkedBlockingQueue(){
        ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 20; i++) {
            tp.execute(new MyThread());
        }
        tp.shutdown();
    }
    /*
    有界队列：当使用有限的 maximumPoolSizes时，有界队列（如 ArrayBlockingQueue）有助于防止资源耗尽，但是可能较难调整和控制。
    队列大小和最大池大小可能需要相互折衷：使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系统资源和上下文切换开销，
    但是可能导致人工降低吞吐量。如果任务频繁阻塞（例如，如果它们是 I/O边界）， 则系统可能为超过您许可的更多线程安排时间。
    使用小型队列通常要求较大的池大小，CPU使用率较高，但是可能遇到不可接受的调度开销，这样也会降低吞吐量。
     */
    public void textArrayBlockingQueue(){
        ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        for (int i = 0; i < 20; i++) {
            tp.execute(new MyThread());
        }
        tp.shutdown();
    }
}

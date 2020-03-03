package ljtao.javase.thread.threadpool.my_make;

/**
 * @author ljtao3 on 2020/3/3
 */
public interface MyExecutorService {
    public void execute(Runnable task);
    public void shutdown();
}

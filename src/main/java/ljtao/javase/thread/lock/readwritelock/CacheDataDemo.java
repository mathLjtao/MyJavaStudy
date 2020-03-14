package ljtao.javase.thread.lock.readwritelock;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ljtao3 on 2020/3/10
 * 读写锁降级事例
 */
public class CacheDataDemo {
    private final static ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private final static Lock readLock=lock.readLock();
    private final static Lock writeLock=lock.writeLock();
    private static HashMap<String ,String> cacheMap=new HashMap<>();
    private static HashMap<String ,String> dataSourceMap=new HashMap<>();

    public static void main(String[] args) {
        cacheMap.put("2","b");
        dataSourceMap.put("1","a");
        dataSourceMap.put("2","b");
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                new CacheDataDemo().processCachedData("1");
            }).start();
        }

    }
    /*
        缓存组件事例
     */
    public void  processCachedData(String id) {
        String data;
        readLock.lock();
        try {
            data=cacheMap.get(id);
            if (data == null) { //缓存里面没有该数据，准备从数据库读取。全部查询数据库，缓存雪崩
                readLock.unlock();//释放读锁，改成写锁，避免所有获取资源的线程全部进入数据库读取数据，造成"缓存雪崩"
                System.out.println("准备进入数据库读数据------------");
                Thread.sleep(100);
                writeLock.lock();//这里改成写锁后，就只有一个线程进入数据库读取数据
                try {
                    data=cacheMap.get(id);
                    if (data == null) { //双重校验，防止有其他线程改变了当前的值，从而出现重复处理的情况
                        System.out.println("进入数据库读取数据");
                        Thread.sleep(5000);
                        data = dataSourceMap.get(id);
                        cacheMap.put(id, data);
                        System.out.println("读取完毕，并保存在cache中");
                    }
                    else{
                        System.out.println("第二次判断，cache数据不是null----");
                    }
                    readLock.lock();//加读锁降级写锁，这样就不会有其他线程能个修改这个值，保证数据的一致性
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    writeLock.unlock();//释放写锁
                }
            }
            use(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            readLock.unlock();
        }
    }

    private void use(String data) {
        System.out.println(Thread.currentThread().getName()+":"+data);
    }

}

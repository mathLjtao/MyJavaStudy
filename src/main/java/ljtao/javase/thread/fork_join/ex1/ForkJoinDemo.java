package ljtao.javase.thread.fork_join.ex1;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author ljtao
 * @date 2020/3/20
 * fork/join 底层是线程池，具体的实现，每个线程有自己的队列来处理，这样提高了执行效率，也不会造成冲突。
 * 也有一个工作窃取的概念，如果有一个线程自己的队列没有任务了，这个线程空闲了，回去帮助其它线程执行他们队列的任务。
 * 普通的线程池，就是所有的线程共同从一个任务队列来拿任务
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool=new ForkJoinPool(10,
                ForkJoinPool.defaultForkJoinWorkerThreadFactory,null,true);


        List<String> list=new ArrayList<>();
        list.add("getUser1");
        list.add("getUser2");
        list.add("getUser3");
        list.add("getUser4");

        HttpJsonRequest task=new HttpJsonRequest(list,0,list.size()-1);
        ForkJoinTask<JSONObject> resultTask =  forkJoinPool.submit(task);
        JSONObject result = resultTask.get();
        System.out.println(result);
    }
}
//任务
class HttpJsonRequest extends RecursiveTask<JSONObject>{

    private List<String> urlList;
    private int start;
    private int end;
    public HttpJsonRequest(List<String> urlList,int start,int end){
        this.urlList=urlList;
        this.start=start;
        this.end=end;
    }
    //就是实际去执行的一个方法入口。（任务拆分）
    @Override
    protected JSONObject compute() {

        int count=end-start;//代表当前这个task需要处理多少数据
        if(count==0){
            //这里输出线程的名称，可以看到是不同的线程在执行拆封的任务
            System.out.println(Thread.currentThread().getName());

            String url=urlList.get(start);
            JSONObject value=new JSONObject();
            value.put(url+","+start+",key",url+","+start+",value");

            return value;

        }else{
            //
            //如果是多个接口调用，拆分成子任务 ， 0，1，  2，3
            //不断将任务拆分
            int x=(start+end)/2;
            HttpJsonRequest httpJsonRequest1 = new HttpJsonRequest(urlList, start, x);
            httpJsonRequest1.fork();//继续执行，将任务继续提交到线程池的任务队列中

            HttpJsonRequest httpJsonRequest2=new HttpJsonRequest(urlList,x+1,end);
            httpJsonRequest2.fork();

            //join处理结果
            JSONObject result=new JSONObject();
            result.putAll(httpJsonRequest1.join());
            result.putAll(httpJsonRequest2.join());
            return result;
        }
    }
}
package ljtao.javase.thread.callable.ex1_simple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ApproveCallable implements Callable {
    private String name;
    public ApproveCallable(String begin){
        name=begin;

    }
    @Override
    public Object call() throws Exception {
        Map<String,String> reHm=new HashMap<>();
        reHm.put("a","table");
        reHm.put("b","tr");
        reHm.put("c","td");
        reHm.put("name",name);
        Thread.sleep(3000);
        return reHm;
    }
}

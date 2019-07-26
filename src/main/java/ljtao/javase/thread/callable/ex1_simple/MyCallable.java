package ljtao.javase.thread.callable.ex1_simple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private String name;
    public MyCallable(String begin){
        name=begin;

    }
    @Override
    public Object call() throws Exception {
        Map<String,String> reHm=new HashMap<>();
        reHm.put("a","table");
        reHm.put("b","div");
        reHm.put("c","span");
        reHm.put("name",name);
        return reHm;
    }
}

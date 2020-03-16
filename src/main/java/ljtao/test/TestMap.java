package ljtao.test;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljtao
 * @date 2020/3/14
 */
public class TestMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> chm=new ConcurrentHashMap();
        chm.put("a","b");
        chm.get("a");

        HashSet hs=new HashSet();
        hs.add("1");
    }
}

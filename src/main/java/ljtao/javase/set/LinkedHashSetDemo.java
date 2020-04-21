package ljtao.javase.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ljtao3 on 2020/4/20
 *
 * LinkedHashSet 继承自 HasHSet 具有HasHSet 的优点，内部使用链表维护了元素 插入顺序 。
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {

    }
    /*
    测试 LinkedHashSet 的一些用法
     */
    @Test
    public void fun1(){
        //维护插入顺序
        Set<Integer> set=new  LinkedHashSet<>();
        set.add(2);
        set.add(93);
        set.add(20);
        set.add(10);
        for (Integer i:set){
            System.out.print(i+",");// 2,93,20,10,
        }

        Set<Integer> set1=new HashSet<>();
        set1.add(2);
        set1.add(93);
        set1.add(20);
        set1.add(10);
        for (Integer i:set1){
            System.out.print(i+",");// 2,20,10,93,
        }
    }

}

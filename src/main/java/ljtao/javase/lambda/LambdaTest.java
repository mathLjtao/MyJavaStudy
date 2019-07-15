package ljtao.javase.lambda;

import java.util.*;

/*
lambda一些知识
 */
public class LambdaTest {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        Map<String,String> hm=new HashMap<>();
        hm.put("a","21");
        hm.put("b","22");
        hm.put("c","23");
        System.out.println("普通方式遍历：");
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> s : hm.entrySet()) {
            System.out.println("key:"+s.getKey()+",value:"+s.getValue());
        }
        System.out.println("Lambda方式遍历：");
        hm.forEach((k, v) -> {
            System.out.println("k=" + k + "，v=" + v);
        });
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println("普通方式遍历：");
        for(String s:list){
            System.out.println("s="+s);
        }
        System.out.println("Lambda方式遍历：");
        list.forEach(v->{
            System.out.println("v="+v);
        });
        System.out.println("list双冒号符运算遍历：");
        list.forEach(System.out::println);
    }
    public static void test2(){
        List<User> list1=new ArrayList<>();
        list1.add(new User(1,"aa"));
        list1.add(new User(2,"bb"));
        list1.add(new User(3,"cc"));
        list1.forEach(v->{
            if(v.getAge()>1){
                System.out.println(v.getName());
            }
        });

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("普通创建线程");
            }
        };
        Runnable r2=()->{
            System.out.println("lambda方式创建线程");
        };
        Thread t=new Thread(r2);
        t.start();
    }
}
class User{
    private int age;
    private String name;
    User(){}
    User(int age,String name){
        this.age=age;
        this.name=name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

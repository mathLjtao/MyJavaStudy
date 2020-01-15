package ljtao.book_study.effective_java.my_code.chapter04.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo1 {
    //如果这个是public范围的，会被改变数组里面的内容。弄成私有的,外部就不能获取了。
    private  final static String[]  VALUES={"A","B","C"};


    //转成不可变集合
    public final  static List<String> VALUES_LIST = Collections.unmodifiableList(Arrays.asList(VALUES));
    //这个方式避免更改
    public String[] getValues1(){
        return VALUES.clone();
    }

    
    
    public static void main(String[] args) {
        Demo1 demo1=new Demo1();
        demo1.VALUES[0]="D";
        for (String value : demo1.VALUES) {
            System.out.println(value);
        }

        System.out.println("-------");

        demo1.VALUES_LIST.set(1,"kkk");//这个执行更改了，会报错
        for (String s : demo1.VALUES_LIST) {
            System.out.println(s);
        }

    }
}

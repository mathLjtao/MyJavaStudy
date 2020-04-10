package ljtao.interview.view02;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author ljtao3 on 2020/4/10
 */
public   class Demo01 {
    final String d="dd";

    public static void main(String[] args) {
        fun4();
    }

    public static void fun1(){
        float f0=1/3;//  1/3=1  ，32位int转32位float不会出错
        float f=3.3f;
        Float f1=3.3f;
        //Float f2=3.3;//这个会报错，3.3默认是double ，64位的，转32位类型会报错

        double d1=3.3;
        double d2=3.3d;
        double d3=3.3f;//32位可以转64位

        long lo1=22;
    }
    public static void fun2(){
        //Demo02类是抽象的，不能被初始化
        //new Demo02();
    }
    //重载只看传入参数、方法名是否一样。传入参数一样，返回类型就算不一样，也会报错。
//    public int  fun3(String a){
//        return 1;
//    }
    public String fun3(String a){
        return "d";
    }
    public static void fun4(){
        //HashMap key跟value 都可以 存null
        Map<String,String> hm=new HashMap<>();
        hm.put(null,null);
        hm.put(null,"value01");
        System.out.println(hm.get(null));

        //Hashtable key跟value 都不可以 存null
        Map<String,String> ht=new Hashtable<>();
        //ht.put(null,null);
        //ht.put(null,"value01");
        //System.out.println(ht.get(null));
    }

}
// final不能修饰 abstract 类
abstract class Demo02{
    Demo02(String str){}
}
//父类有构造方法，子类必须实现父类有的构造方法。（没有参数的构造方法可以不用实现）
class Demo03 extends Demo02{
    Demo03(String str) {
        super(str);
    }
}
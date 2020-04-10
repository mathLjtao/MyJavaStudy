package ljtao.book_study.java8Action.mycode.chapter03;

import ljtao.book_study.java8Action.sourceCode.chap2.FilteringApples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ljtao3 on 2020/4/10
 */
public class Quote {
    public static void main(String[] args) {

    }
    //方法引用
    public static void fun1(){
        Function<String,Integer> stringToInteger=(String s)-> Integer.parseInt(s);
        //可以变化为
        Function<String,Integer> stringToInteger2=Integer::parseInt;

        BiPredicate<List<String>, String> contains =
                (list, element) -> list.contains(element);
        //可以变化为
        BiPredicate<List<String>, String> contains2 =
                List::contains;
    }
    //获得一个具有不同重量苹果的list
    public static void fun3(){
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

    }
    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer e: list){
            result.add(f.apply(e));
        }
        return result;
    }
    //构造函数的引用
    public static void fun2(){
        //创建一个对象
        Supplier<Apple> supplier2=()->new Apple();
        //也可以写成这样
        Supplier<Apple> supplier1=Apple::new;

        //如果构造函数是有参数的
        Function<Integer,Apple> function1=(Integer i)->new Apple(i);
        Function<Integer,Apple> function2=Apple::new;

    }


    static class Apple{
        public Apple() {

        }
        public Apple( Integer weight){}

        public int getWeight() {
            return 1;
        }
    }

}


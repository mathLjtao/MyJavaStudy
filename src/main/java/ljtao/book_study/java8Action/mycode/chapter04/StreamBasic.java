package ljtao.book_study.java8Action.mycode.chapter04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;


/**
 * @author ljtao
 * @date 2020/4/11
 */
public class StreamBasic {
    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );
    public static void main(String[] args) {
        //fun0();
        //fun1();
        //fun2();
        fun3();
    }
    public static void fun0(){

        /*
            forEach是一个返回void的终端操作
            返回Stream类型的方法属于中间操作，如，filter,map,limit
            返回非Stream类型的方法属于终端操作,如，collect，count，forEach
         */
        //最佳方式
        menu.stream().filter(d->d.getCalories()>300).map(d->d.getName()).limit(3)
                .collect(toList())
                .forEach(System.out::println);
    }
    //展示流的处理顺序
    public static void fun1(){
        //System.out.println(menu.stream().limit(4).collect(toList()));
        menu.stream().filter((Dish d)->{
            System.out.println("filter "+d.getName());
            return d.getCalories()>300;
        }).map((Dish d)->{
            //map----接受一个Lambda，将 元素 转换成 其他形式或提取信息。在本例中，通过传递方
            //法引用Dish::getName，相当于Lambda d -> d.getName()，提取了每道菜的菜名。
            System.out.println("map "+d.getName());
            return d.getName();
        }).limit(4).collect(toList());
    }
    //其它用法
    public static void fun2(){
        //{OTHER=
        // [Dish{name='season fruit', vegetarian=true, calories=120, type=OTHER}, Dish{name='rice', vegetarian=true, calories=350, type=OTHER}],
        // FISH=[Dish{name='prawns', vegetarian=false, calories=300, type=FISH}]}
        Map<Dish.Type, List<Dish>> collect = menu.stream().sorted(comparing(d -> d.getCalories())).limit(3)
                .collect(groupingBy(d -> d.getType()));
        System.out.println(collect);
    }
    //
    public static void fun3(){
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,2,3,5,2,4,4,8);
        // 2,4,6,8,
        //distinct方法，返回一个元素各异的流
        list.stream().filter(i->i%2==0)
                .distinct()
                .collect(toList())
                .forEach(i->System.out.print(i+","));
    }
    //limit(n)和skip(n)是互补的,,,skip是跳过前面几个元素
}

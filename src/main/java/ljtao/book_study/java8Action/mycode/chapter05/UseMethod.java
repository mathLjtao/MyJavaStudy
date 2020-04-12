package ljtao.book_study.java8Action.mycode.chapter05;

import ljtao.book_study.java8Action.mycode.chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author ljtao
 * @date 2020/4/12
 *
 * 介绍stream一些复杂的用法
 */
public class UseMethod {
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
        //fun2();
        fun3();
    }

    /**
     * 查找和匹配
     */
    //anyMatch方法可以回答“流中是否有一个元素能匹配给定的谓词”。
    //比如，你可以用它来看看菜单里面是否有素食可选择：
    public static void  fun1(){

        if(menu.stream().anyMatch(d->d.isVegetarian())){
            System.out.println("菜单中有蔬菜");
        }
        //anyMatch方法返回一个boolean，因此是一个终端操作。
        if(menu.stream().allMatch(d->d.isVegetarian())){
            System.out.println("菜单所有的菜都是蔬菜");
        }
        if(menu.stream().noneMatch(d->d.isVegetarian())){
            System.out.println("菜单所有的菜都不是蔬菜");
        }
    }
    //查找元素
    public static void fun2(){
        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findAny();
        //如果值存在，则返回true
        boolean present = any.isPresent();
        //如果值存在，做出相应的操作
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));//french fries

        Dish dish = any.get();
        //Dish{name='french fries', vegetarian=true, calories=530, type=OTHER}
        System.out.println(dish);

        //如果存在则返回，不存在则返回默认的元素
        Dish dish2 = any.orElse(new Dish("pizza", true, 800, Dish.Type.MEAT));
        //Dish{name='french fries', vegetarian=true, calories=530, type=OTHER}
        System.out.println(dish2);

        //查找第一个元素
        Optional<Dish> first = menu.stream().filter(Dish::isVegetarian).findFirst();
        //Optional[Dish{name='french fries', vegetarian=true, calories=530, type=OTHER}]
        System.out.println(first);
    }
    //归约
    public static void fun3(){
        List<Integer> integers = Arrays.asList(5, 1, 2, 3, 4);
        List<Integer> integers2 = Arrays.asList();
        //0为初始值
        Integer r1 = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(r1);//15

        Integer r11 = integers.stream().reduce(0, Integer::sum);
        System.out.println(r11);//15

        Optional<Integer> r2 = integers.stream().reduce((a, b) -> a + b);
        System.out.println(r2);//Optional[15]

        Optional<Integer> r3 = integers2.stream().reduce((a, b) -> a + b);
        System.out.println(r3);//Optional.empty


        //最大值
        Integer r4 = integers.stream().reduce(0, (a, b) -> a > b ? a : b);
        //integers.stream().reduce(0,Integer::max);
        System.out.println(r4);//5
        //最小值
        Integer r5 = integers.stream().reduce(0, (a, b) -> a < b ? a : b);
        //integers.stream().reduce(0,Integer::min);
        System.out.println(r5);//0

    }


}

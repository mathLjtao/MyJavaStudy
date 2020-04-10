package ljtao.book_study.java8Action.mycode.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljtao3 on 2020/4/9
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory= Arrays.asList(new Apple(80,"green"),
                new Apple(155,"green"),new Apple(120,"red"));

        //[Apple{weight=80, color='green'}, Apple{weight=155, color='green'}]
        List<Apple> list1 = FilteringApples.filter(inventory, new ColorApplePredicate());
        System.out.println(list1);

        //[Apple{weight=155, color='green'}]
        List<Apple> list2 = FilteringApples.filter(inventory, new WeightApplePredicate());
        System.out.println(list2);

        //[Apple{weight=155, color='green'}, Apple{weight=120, color='red'}]
        //使用匿名类
        List<Apple> list3 = FilteringApples.filter(inventory, new ApplePredicate(){
            @Override
            public boolean check(Apple apple) {
                return apple.getWeight()>150 || "red".equals(apple.getColor());
            }
        });
        System.out.println(list3);

        //[Apple{weight=120, color='red'}]
        List<Apple> list4 = FilteringApples.filter(inventory, (Apple a)->"red".equals(a.getColor()));
        System.out.println(list4);

    }
    //体现了策略模式,想根据什么筛选就传递什么实现类
    public static List<Apple> filter(List<Apple> inventory ,ApplePredicate applePredicate){
        List<Apple> result=new ArrayList<>();
        for (Apple apple:inventory){
            if(applePredicate.check(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate{
        boolean check(Apple apple);
    }
    static class ColorApplePredicate implements ApplePredicate{
        @Override
        public boolean check(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }
    static class WeightApplePredicate implements ApplePredicate{
        @Override
        public boolean check(Apple apple) {
            return apple.getWeight()>150;
        }
    }
    static class Apple{
        private int weight=0;
        private String color="";
        Apple(int i,String color){
            weight=i;
            this.color=color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}


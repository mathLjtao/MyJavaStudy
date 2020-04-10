package ljtao.book_study.java8Action.mycode.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ljtao3 on 2020/4/9
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory= Arrays.asList(new Apple(80,"green"),
                new Apple(155,"green"),new Apple(120,"red"));

        //[Apple{weight=80, color='green'}, Apple{weight=155, color='green'}]
        List<Apple> apples0 = FilteringApples.fileterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(apples0);

        //[Apple{weight=80, color='green'}, Apple{weight=155, color='green'}]
        List<Apple> apples1 = FilteringApples.fileterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(apples1);

        //[Apple{weight=155, color='green'}, Apple{weight=120, color='red'}]
        List<Apple> apples2 = FilteringApples.fileterApples(inventory,
                (Apple a) -> "red".equals(a.getColor()) || a.getWeight()>150);
        System.out.println(apples2);
    }
    public static List<Apple> fileterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
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

package ljtao.book_study.java8Action.mycode.chapter10;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author ljtao3 on 2020/4/14
 * 用Optional取代null,,,感觉没用。避免null指针，还是要靠程序自己写规范的程序来避免。
 */
public class Person {
    public static void main(String[] args) {
        Person person=new Person();
        person.setCar(Optional.of(null));
        //果car是一个null，这段代码会立即抛出一个NullPointerException，而不是等到试图访问car的属性值时才返回一个错误。
        Optional<Car> car = person.getCar();
        System.out.println(car);
    }
    private Optional<Car> car;//人可以有车或者没车
    public void setCar(Optional<Car> car){
        this.car=car;
    }
    public Optional<Car> getCar(){
        return this.car;
    }
}
class Car{
    private Optional<Insurance> insurance;//车可以有保险或者没有保险
    public Optional<Insurance> getInsurance(){
        return  this.insurance;
    }
}
class Insurance{
    private String name;//保险一定要有名字
    public String getName(){
        return  this.name;
    }
}

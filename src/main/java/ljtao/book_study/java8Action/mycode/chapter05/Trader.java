package ljtao.book_study.java8Action.mycode.chapter05;

/**
 * @author ljtao
 * @date 2020/4/12
 */

public class Trader{
    private final String name;
    private final String city;
    public Trader(String name,String city){
        this.name=name;
        this.city=city;
    }

    public String getName() {
        return name;
    }


    public String getCity() {
        return city;
    }

    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }


}

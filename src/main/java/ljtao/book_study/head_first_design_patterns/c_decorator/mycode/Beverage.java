package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 * 饮料类
 */
public abstract class Beverage {
    String description="unknow Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double  cost();
}

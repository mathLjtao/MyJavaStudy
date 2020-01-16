package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 * 浓缩饮料类
 */
public class Espresso extends Beverage{
    public Espresso(){
        description="Espresso";

    }
    @Override
    public double cost() {
        return 1.99;
    }
}

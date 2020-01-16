package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 * 综合类饮料类
 */
public class HouseBlend extends Beverage{
    public HouseBlend(){
        description="House Blend Coffee";

    }
    @Override
    public double cost() {
        return 0.89;
    }
}

package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 * 必须让CondimentDecorator 能够取代Beverage，所以让CondimentDecorator扩展自Beverage
 */
public abstract class CondimentDecorator extends Beverage{
    @Override
    public abstract String getDescription();
}

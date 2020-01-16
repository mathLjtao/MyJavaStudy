package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 * 实现具体装饰者 macha类
 */
public class Whip extends CondimentDecorator{
    private Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",whip";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.1;
    }
}

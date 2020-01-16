package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 * 实现具体装饰者 macha类
 */
public class Mocha extends CondimentDecorator{
    private Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",mocha";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.2;
    }
}

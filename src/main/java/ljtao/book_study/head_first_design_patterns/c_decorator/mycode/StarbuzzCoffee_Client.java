package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

/**
 * @author ljtao3 on 2020/1/13
 *
 * 星巴克订饮料
 * 咖啡
 * 综合 : .89
 * 深焙 .99
 * 低咖啡因 1.05
 * 浓缩(Espresso) 1.99
 *
 * 配料
 * 牛奶 .1
 * 摩卡 .2
 * 豆浆 .15
 * 奶泡 .1
 *
 */
public class StarbuzzCoffee_Client {
    public static void main(String[] args) {
        //点一杯浓缩咖啡，加上摩卡，加上奶泡
        Beverage beverage1=new Espresso();
        beverage1=new Mocha(beverage1);
        beverage1=new Whip(beverage1);
        System.out.println(beverage1.getDescription()+":"+beverage1.cost());

        //点一杯综合咖啡，不加任何调料
        Beverage beverage2=new HouseBlend();
        System.out.println(beverage2.getDescription()+":"+beverage2.cost());
    }
}

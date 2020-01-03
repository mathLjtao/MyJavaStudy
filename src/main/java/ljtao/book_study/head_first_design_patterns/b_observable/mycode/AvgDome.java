package ljtao.book_study.head_first_design_patterns.b_observable.mycode;

public class AvgDome implements Observer ,DisplayElement {
    @Override
    public void display() {
        System.out.println("显示平均值");
    }

    @Override
    public void update(String temperature, String humidity, String pressure) {
        display();
        //显示平均值
        System.out.println("current:"+temperature+","+humidity+","+pressure);
    }
}

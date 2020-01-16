package ljtao.book_study.effective_java.my_code.chapter06.item34;

/**
 * @author ljtao3 on 2020/1/14
 */
public class Test {
    public static void main(String[] args) {
        double v = Planet.EARTH.surfaceWeight(2.3);
        System.out.println(v);
        Planet[] values = Planet.values();
    }
}

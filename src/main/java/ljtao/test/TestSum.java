package ljtao.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author ljtao3 on 2020/3/30
 */
public class TestSum {
    public static DecimalFormat fnum = new DecimalFormat("##0.000000");
    public static void main(String[] args) {

        fun2();





    }
    public static void fun1(){



        //转成字符串，再输入进入，才会正确

        BigDecimal b1=new BigDecimal(11540D+"");
        Double dou=11540D;
        Double dou1=0.35D;
        System.out.println(dou*dou1);

        BigDecimal b2=new BigDecimal(0.35D+"");


        System.out.println(b1);
        System.out.println(b1.multiply(b2));
    }

    //
    public static void fun2()
    {
        BigDecimal b=new BigDecimal(11540.33);
        BigDecimal b1=new BigDecimal(11540.33+"");
        System.out.println(b);
        System.out.println(b1);
    }
}

package ljtao.book_study.effective_java.my_code.chapter06.item34;

import java.util.ArrayList;

/**
 * @author ljtao3 on 2020/1/14
 * 枚举的一个实例.（具体还是看作者的源码，这里只是随便弄几个数据来测试）
 * 记录行星的质量跟半径
 * 然后可以计算出在星球上物品的重力。
 */
public enum Planet {
    EARTH(1,2),
    MARS(2,3);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private final double G=6.67;
    Planet(int mass,int radius){
        this.mass=mass;
        this.radius=radius;
        surfaceGravity=G*mass/(radius*radius);
    }
    public double mass(){
        return mass;
    }
    public double radius(){
        return radius;
    }
    public double surfaceGravity(){
        return surfaceGravity;
    }
    //查询物品的重力
    public double surfaceWeight(double mass){
        //F=ma
        return mass*surfaceGravity;
    }
}

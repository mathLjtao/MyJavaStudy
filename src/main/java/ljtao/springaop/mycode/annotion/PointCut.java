package ljtao.springaop.mycode.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
方法切入点
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})//使用范围，方法
public @interface PointCut {
    /*
        全类名_方法名
     */
    String value();

}

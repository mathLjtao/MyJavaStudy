package ljtao.javase.annotation.ex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/*

 */
public class TestIsBug {
    public static void main(String[] args) {
        demo1();
    }

    //检查NoBug类中带有@jiancha注解的方法是否有bug
    public static void  demo1(){
        Class clazz=NoBug.class;
        Method[] declaredMethods =clazz.getDeclaredMethods();
        for(Method m:declaredMethods){
            if(m.isAnnotationPresent(jiancha.class)){
                try{
                    m.invoke(clazz.newInstance(),null);
                }
                catch (Exception e){
                    System.out.println("发生异常的方法名称："+m.getName());
                    System.out.println(e.getCause().getClass().getSimpleName()+e.getCause().getMessage());
                }
            }
        }
    }
}

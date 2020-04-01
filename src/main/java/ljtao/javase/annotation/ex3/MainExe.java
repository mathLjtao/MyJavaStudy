package ljtao.javase.annotation.ex3;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * @author ljtao3 on 2020/3/31
 */
public class MainExe {
    public static void main(String[] args) throws Exception {
        fun1();
    }
    /*
        加入方法后，在target文件下相应的类.class文件，有相应的代码生成
     */
    public static void fun1() throws Exception {
        ClassOperate classOperate=new ClassOperate();
        classOperate.doClassOperate();
    }
}

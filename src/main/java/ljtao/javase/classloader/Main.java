package ljtao.javase.classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class Main {


    public static void main(String args[]) throws Exception {
        Main m=new Main();
        m.demo1();
    }
    /*
    自定义类加载器加载
     */
    public void demo1()throws Exception{
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        //Class clazz = classLoader.loadClass("ljtao.javase.classloader.Test");
        Class clazz = classLoader.findClass("ljtao.javase.classloader.Test");
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj, null);
    }
    public void demo2(){

    }
}
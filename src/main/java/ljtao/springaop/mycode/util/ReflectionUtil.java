package ljtao.springaop.mycode.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ljtao3 on 2020/3/6
 */
public class ReflectionUtil {
    //创建实例
    public static Object newInstance(Class<?> cls){
        Object instance;
        try {
            instance=cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return instance;

    }
    //创建实例，根据类名
    public static Object newInstance(String className){
        Class<?> aClass = ClassUtil.loadClass(className);
        return newInstance(aClass);
    }
    //调用方法
    public static Object invokeMethod(Object obj, Method method,Object... args){
        Object result;
        try {
            method.setAccessible(true);
            result=method.invoke(obj,args);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }
    //设置成员变量的值
    public static void setField(Object obj, Field field,Object value){
        field.setAccessible(true);
        try {
            field.set(obj,value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

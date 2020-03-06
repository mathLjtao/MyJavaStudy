package ljtao.pattern.m_proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 需要导包 cglib.jar
 * @author ljtao3
 *
 */
public class CglibInfoProxy implements MethodInterceptor {
    private Object target;
    public Object newInstance(Object source){
        target = source;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method!!!");
        //,这里不要写成invoke()方法，要不然会一直回调
        Object value = methodProxy.invokeSuper(o, objects);
        //Object value = methodProxy.invoke(o, objects);
        return value;
    }
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\\\classes");
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\workspaces\\MyJavaStudy\\src\\main\\java");
        InfoDemo instance = (InfoDemo) new CglibInfoProxy().newInstance(new InfoDemo());
        instance.welcome("zhangsan");
    }
}


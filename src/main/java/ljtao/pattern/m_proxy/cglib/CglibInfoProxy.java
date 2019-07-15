package ljtao.pattern.m_proxy.cglib;
/**
 * 需要导包 cglib.jar和asm.jar
 * @author ljtao3
 *

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
        Object value = methodProxy.invokeSuper(o, objects);
        //Object value = methodProxy.invoke(o, objects);
        return value;
    }
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\\\classes");
        InfoDemo instance = (InfoDemo) new CglibInfoProxy().newInstance(new InfoDemo());
        instance.welcome("zhangsan");
    }
}
 */

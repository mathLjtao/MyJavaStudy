package ljtao.springaop.mycode.proxy;

import ljtao.springaop.mycode.util.StringUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ljtao3 on 2020/3/6
 */
public abstract class AbsMethodAdvance implements MethodInterceptor {

    //要被代理的对象
    private Object targetObject;

    private String proxyMethodName;

    public Object createProxyObject(Object source){
        this.targetObject=source;
        //用于生成代理对象
        Enhancer enhancer=new Enhancer();
        //设置目标类为代理对象的父类
        enhancer.setSuperclass(this.targetObject.getClass());
        //设置回调用对象为本身
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result;
        String proxyMethod=getProxyMethodName();

        if(StringUtil.isNotBlank(proxyMethod)&&proxyMethod.equals(method.getName())){
            doBefore();
        }
        //执行拦截的方法  ,这里不要写成invoke()方法，要不然会一直回调
        result=methodProxy.invokeSuper(o,objects);

        if(StringUtil.isNotBlank(proxyMethod)&&proxyMethod.equals(method.getName())){
            doAfter();
        }
        return result;
    }

    public abstract void doBefore();
    public abstract void doAfter();

    public String getProxyMethodName(){
        return proxyMethodName;
    }
    public void setProxyMethodName(String proxyMethodName){
        this.proxyMethodName=proxyMethodName;
    }

}

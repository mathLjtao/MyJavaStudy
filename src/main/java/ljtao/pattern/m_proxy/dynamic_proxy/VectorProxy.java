package ljtao.pattern.m_proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler{
	private Object proxyobj;
	public VectorProxy(Object obj){
		System.out.println("VectorProxyg构造方法运行了！！");
		proxyobj=obj;
	}
	//静态工厂方法
	public static Object factory(Object obj){
		Class cls=obj.getClass();
		
		return Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),new VectorProxy(obj));
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before calling "+method);
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]+" ");
			}
		}
		Object o=method.invoke(proxyobj, args);
		System.out.println("after calling "+method);
		return o;
	}
	public static void main(String[] args) {
		List v=null;
		v=(List)factory(new Vector(10));
		v.add("one ");
		v.add("two ");
		//可以用自己创建的接口跟类来测试
	}
	//https://www.cnblogs.com/cenyu/p/6289209.html
}

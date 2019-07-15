package ljtao.pattern.m_proxy;

import ljtao.pattern.m_proxy.staticproxy.ProxySubject;
import ljtao.pattern.m_proxy.staticproxy.Subject;


public class Test {
	public static void main(String[] args) {
		proxy1();
	}
	/**
	 * 静态代理的测试
	 * 使用代理主题时，要将对象的明显类型声明为抽象主题的类型，而将其真实类型设为代理主题类型，
	 */
	public static  void proxy1(){
		Subject sbj=new ProxySubject();
		sbj.request();
	}
	/**
	 * 动态代理的测试
	 */
	public static  void proxy2(){
	}
}
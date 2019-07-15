package ljtao.javase.reflect;

public class A4_TestClassType {
	public A4_TestClassType(){
		System.out.println("---构造函数---");
	}
	static {
		System.out.println("---静态的参数初始化----.");
	}
	{
		System.out.println("---非静态参数初始化---");
	}
}

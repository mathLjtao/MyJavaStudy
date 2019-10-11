package ljtao.pattern.a_singleton;

public class Singleton {
	private Singleton() {
		System.out.println("该单例对象要运行的代码");
		Test test=new Test();
	}
	//用到的时候才加载
	//静态变量只初始化一次，所以对象是单例的。
	public static Singleton getSingleton() {
		return singletonInstance.singleton;
	}
	//运用内部类
	private static class singletonInstance{
		static  Singleton singleton=new Singleton();
		
	}
}

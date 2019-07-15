package ljtao.javase.reflect;

public class A3_TestClass {
	public static void main(String[] args) throws Exception{
		/*
		https://blog.csdn.net/qq_39209361/article/details/81239189 对反射的理解
		//Class.forName("类名字符串")  （注：类名字符串是包名+类名）  说明：装入类,并做类的静态初始化，返回Class的对象
		Class clazz1=Class.forName("ljtao.javase.reflect.A4_TestClassType");
		System.out.println("forName---"+clazz1);
		
		Thread.currentThread().sleep(2000);
		
		A4_TestClassType t=new A4_TestClassType();
		//.实例对象.getClass()  说明：对类进行静态初始化、非静态初始化；返回引用运行时真正所指的对象(因为:子对象的引用可能会赋给父对象的引用变量中)所属的类的Class的对象
		Class clazz3=t.getClass();
		System.out.println("getClass--"+clazz3);
		Thread.currentThread().sleep(2000);
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
		*/
		//JVM将使用类装载器, 将类装入内存(前提是:类还没有装入内存),不做类的初始化工作.返回Class的对象
		Class clazz2=A4_TestClassType.class;
		System.out.println("class---"+clazz2);
		/**
		 * 根据结果可以发现，三种生成的Class对象一样的。并且程序只打印一次“静态的参数初始化”。 
		静态的方法属性初始化，是在加载类的时候初始化。而非静态方法属性初始化，是new类实例对象的时候加载。
		因此，这段程序说明，三种方式生成Class对象，其实只有一个Class对象。在生成Class对象的时候，首先判断内存中是否已经加载。
		所以，生成Class对象的过程其实是如此的：
		当我们编写一个新的java类时,JVM就会帮我们编译成class对象,存放在同名的.class文件中。在运行时，当需要生成这个类的对象，
		JVM就会检查此类是否已经装载内存中。若是没有装载，则把.class文件装入到内存中。若是装载，则根据class文件生成实例对象。
		 */
		/**
		 * 那么Java反射有什么作用呢？
		 * 假如我们有两个程序员，一个程序员在写程序的时候，需要使用第二个程序员所写的类，但第二个程序员并没完成他所写的类。
		 * 那么第一个程序员的代码能否通过编译呢？这是不能通过编译的。利用Java反射的机制，就可以让第一个程序员在没有得到第二个程序员所写的类的时候，来完成自身代码的编译。

		 * Java的反射机制它知道类的基本结构，这种对Java类结构探知的能力，我们称为Java类的“自审”。
		 * 大家都用过Jcreator和eclipse。当我们构建出一个对象的时候，去调用该对象的方法和属性的时候。一按点，编译工具就会自动的把该对象能够使用的所有的方法和属性全部都列出来，
		 * 供用户进行选择。这就是利用了Java反射的原理，是对我们创建对象的探知、自审。
		 */
	}
}

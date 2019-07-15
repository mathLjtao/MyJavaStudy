package ljtao.book_JavaProgramOptimization.c_5_otherskill;

import java.util.Vector;

/*
 * 使用clone代替new
 */
public class TestClone {
	public static void main(String[] args) {
		demo2();
	}
	/*
	 * 测试一下clone出来的对象
	 * 1、调用clone()生成的stu2时，没有调用构造函数。
	 * 2、对于Vector对象等普通对象，克隆对象拥有和原始对象相同的引用，而不是值拷贝，即浅拷贝。
	 * 3、对于int、string等基本对象是 值拷贝。
	 */
	public static void demo1(){
		Student stu=new Student();
		stu.setId(1);
		stu.setName("xiaodong");
		Vector v=new Vector();
		v.add("java");
		stu.setCourses(v);
		
		Student stu2=stu.newInstance();
		stu2.setId(2);
		stu2.setName("xiaoming");
		//只在stu2改变 Vector对象，结果两个都变化了
		stu2.getCourses().add("c#");
		
		System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getCourses());
		System.out.println(stu2.getId()+" "+stu2.getName()+" "+stu2.getCourses());
		System.out.println(stu.getCourses()==stu2.getCourses());
		
	}
	/*
	 * 简单的 深拷贝例子
	 */
	public static void demo2(){
		People p=new People();
		p.setId(1);
		p.setName("xiaodong");
		Vector v=new Vector();
		v.add("java");
		p.setCourses(v);
		
		People p2=p.newInstance();
		p2.setId(2);
		p2.setName("xiaoming");
		//只在p2改变 Vector对象，只有p2中的Vector对象改变了
		p2.getCourses().add("c#");
		
		System.out.println(p.getId()+" "+p.getName()+" "+p.getCourses());
		System.out.println(p2.getId()+" "+p2.getName()+" "+p2.getCourses());
		System.out.println(p.getCourses()==p2.getCourses());
	}
}

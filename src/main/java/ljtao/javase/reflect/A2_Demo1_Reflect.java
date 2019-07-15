package ljtao.javase.reflect;

public class A2_Demo1_Reflect {
	public static void main(String[] args) throws Exception{
		Class  class1 = Class.forName("ljtao.javase.reflect.A1_Person");
		Class class2=A1_Person.class;
		A1_Person p=new A1_Person();
		Class  class3=p.getClass();
		
		System.out.println(class1 == class2);
		System.out.println(class2 == class3);
	}
}

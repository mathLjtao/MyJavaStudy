package ljtao.javase.reflect;

public class A6_Person {
	public A6_Person(){
		System.out.println("---构造函数---");
	}
	private String name = "Alfira";
	static {
		System.out.println("---静态的参数初始化----.");
	}
	{
		System.out.println("---非静态参数初始化---");
	}
    public void getName() {
        System.out.println(name);
    }
    public void setName(String name, int a) {
        this.name = name + a;
    }
}

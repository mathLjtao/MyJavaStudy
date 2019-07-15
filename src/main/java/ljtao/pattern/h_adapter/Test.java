package ljtao.pattern.h_adapter;

public class Test {
	public static void main(String[] args) {
		demo2();
	}
	//演示类设配器
	public static  void demo1(){
		Target t=new Adapter();
		t.simpleDemo1();
		t.simpleDemo2();
	}
	//演示对象设配器
	public static void demo2(){
		Target t=new Adapter2(new Adaptee());
		t.simpleDemo1();
		t.simpleDemo2();
	}
}

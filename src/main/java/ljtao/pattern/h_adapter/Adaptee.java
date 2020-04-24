package ljtao.pattern.h_adapter;
/*
 * 源角色：现有需要设配的接口
 */
public class Adaptee {
	//源类含有的方法
	public void simpleDemo1(){
		System.out.println("demo1");
	}

	//
	private String name="basic";
	public void simpleDemo3(String name){
		this.name=name;
	}
	public void change(){
		System.out.println(this.name);
	}
}

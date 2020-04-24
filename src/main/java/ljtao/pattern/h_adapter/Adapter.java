package ljtao.pattern.h_adapter;
/*
 * 这种是 类的设配器 模式
 * 设配器角色：设配器类是本模式的核心，设配器把源接口转换成目标接口。这一角色不可能是接口，而必须是类
 */
public class Adapter extends Adaptee implements Target{
	/*
		由于源类没有方法Target#simpleDemo2()，
		所以设配器类补充上这个方法
	 */
	@Override
	public void simpleDemo2() {
		System.out.println("demo2");
	}



	
}

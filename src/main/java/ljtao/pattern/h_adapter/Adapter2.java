package ljtao.pattern.h_adapter;
/*
 * 这种是 对象的设配器 模式
 */
public class Adapter2 implements Target{
	private Adaptee adaptee;
	public Adapter2(Adaptee adaptee){
		super();
		this.adaptee=adaptee;
	}
	/*
	 * 源类有方法simpleDemo1()
	 * 因此设配器类 直接委派就行
	 */
	
	@Override
	public void simpleDemo1() {
		adaptee.simpleDemo1();
	}

	@Override
	public void simpleDemo2() {
		System.out.println("demo2");
	}

}

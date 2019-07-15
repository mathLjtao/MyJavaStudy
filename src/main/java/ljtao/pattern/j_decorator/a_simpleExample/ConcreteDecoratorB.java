package ljtao.pattern.j_decorator.a_simpleExample;

public class ConcreteDecoratorB extends Decorator{
	public ConcreteDecoratorB(Component component) {
        super(component);
    }
	public void methodB(){
		System.out.println("新增加的功能");
	}
	public void sampleOperation() {
		System.out.println("针对该方法进行B包装");
		super.sampleOperation();
		System.out.println("包装结束");
	}
}

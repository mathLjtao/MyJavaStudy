package ljtao.pattern.j_decorator.a_simpleExample;

public class ConcreteDecorator extends Decorator{
	public ConcreteDecorator(Component component) {
        super(component);
    }
	public void methodA(){
		System.out.println("新增加的功能");
	}
	//
	public void sampleOperation() {
		// 
		System.out.println("针对该方法进行包装");
		super.sampleOperation();
		System.out.println("包装结束");
	}
}

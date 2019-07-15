package ljtao.pattern.j_decorator.a_simpleExample;

public class Test {
	public static void main(String[] args) {
		ConcreteDecorator decorator = new ConcreteDecorator(new ConcreteComponent());
		decorator.sampleOperation();
	}
}

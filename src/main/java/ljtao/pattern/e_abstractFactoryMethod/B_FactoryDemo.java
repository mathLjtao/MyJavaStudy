package ljtao.pattern.e_abstractFactoryMethod;

interface MyProduct{}
class MyProductA implements MyProduct{}
class MyProductB implements MyProduct{}
interface MyFactory{
	MyProduct getMyProduct();
}
class MyFactoryA implements MyFactory{
	@Override
	public MyProduct getMyProduct() {
		// TODO Auto-generated method stub
		return new MyProductA();
	}
}
class MyFactoryB implements MyFactory{
	@Override
	public MyProduct getMyProduct() {
		// TODO Auto-generated method stub
		return new MyProductB();
	}
}
/*  到这里是我们自己的一套工厂方法模式，去创造我们自己的产品，以下我们将以上二者组合   */

//我们使用组合的方式将我们的产品系列和jar包中的产品组合起来
class AssortedFactory implements MyFactory,Factory{
	MyFactory myFactory;
	Factory factory;
	AssortedFactory(MyFactory myFactory,Factory factory){
		super();
		this.myFactory=myFactory;
		this.factory=factory;
	}
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return factory.getProduct();
	}

	@Override
	public Product1 getProduct1() {
		// TODO Auto-generated method stub
		return factory.getProduct1();
	}

	@Override
	public MyProduct getMyProduct() {
		// TODO Auto-generated method stub
		return myFactory.getMyProduct();
	}
	
}

/*
 * 这个主要测试引用其他包的工厂模式，怎么加入自己的工厂模式。将两者结合起来
 */
public class B_FactoryDemo {
	public static void main(String[] args) {
		MyFactoryA ma=new MyFactoryA();
		FactoryA fa=new FactoryA();
		AssortedFactory af=new AssortedFactory(ma,fa);
	}
}

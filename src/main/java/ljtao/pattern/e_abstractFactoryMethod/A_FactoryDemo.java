package ljtao.pattern.e_abstractFactoryMethod;

interface Product{}
class ProductA implements Product{}
class ProductB implements Product{}
interface Product1{}
class Product1A implements Product1{}
class Product1B implements Product1{}

interface Factory{
	Product getProduct();
	Product1 getProduct1();
}
class FactoryA implements Factory{
	@Override
	public Product getProduct() {
		return new ProductA();
	}
	@Override
	public Product1 getProduct1() {
		return new Product1A();
	}
}
class FactoryB implements Factory{
	@Override
	public Product getProduct() {
		return new ProductB();
	}
	@Override
	public Product1 getProduct1() {
		return new Product1B();
	}
}
//与工厂方法对比下就发现，多了一个产品系列叫Product1，工厂接口里多了一个方法，叫getProduct1，
//所以抽象工厂模式就是工厂方法模式添加了抽象产品所演变而来的。
public class A_FactoryDemo {
	public static void main(String[] args) {
		
	}
}

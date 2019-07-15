package ljtao.pattern.g_strategy;
//这个类中主要演示简单的策略模式
//策略接口
interface Strategy{ void algorithm(); }
//策略A
class ConcreteStrategyA  implements Strategy{
	public void algorithm() {
		System.out.println("策略A");
	}
}
class ConcreteStrategyB  implements Strategy{
	public void algorithm() {
		System.out.println("策略B");
	}
}
class ConcreteStrategyC  implements Strategy{
	public void algorithm() {
		System.out.println("策略C");
	}
}
//上下文对象，
class Context {
	private Strategy strategy;
	public void  method() {
		strategy.algorithm();
	}
	public void setStrategy(Strategy strategy) {
		this.strategy=strategy;
	}
}
public class A_SimpleClient {
	public static void main(String[] args) {
		Context c=new Context();
		ConcreteStrategyA sa=new ConcreteStrategyA();
		//传入不同的接口，实现不同的策略方法。
		c.setStrategy(sa);
		c.method();
		ConcreteStrategyB sb=new ConcreteStrategyB();
		c.setStrategy(sb);
		c.method();
		ConcreteStrategyC sc=new ConcreteStrategyC();
		c.setStrategy(sc);
		c.method();
		
	}
}

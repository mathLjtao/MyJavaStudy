package ljtao.pattern.j_decorator.a_simpleExample;

public class ConcreteComponent implements Component{
	public ConcreteComponent(){
		//write your code here
	}
	@Override
	public void sampleOperation() {
		System.out.println("原有商业方法");
	}

}

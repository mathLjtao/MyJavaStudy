package ljtao.pattern.j_decorator.a_simpleExample;

public class Decorator implements Component{
	private Component component;
	public Decorator(Component component){
		this.component=component;
	}
	public Decorator(){
		//write code
	}
	//商业方法，委派给构件
	@Override
	public void sampleOperation() {
		// TODO Auto-generated method stub
		component.sampleOperation();
	}
	
}

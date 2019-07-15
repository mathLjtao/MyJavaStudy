package ljtao.pattern.f_observer;

import java.util.ArrayList;
import java.util.List;
//观察者对象接口，这个接口是为了提供一个统一的观察者做出相应行为的方法
interface Observer{
	void update(Observable o);
}
class Observer1 implements Observer{
	public void update(Observable o) {
		System.out.println("观察1：观察到"+o.getClass().getSimpleName()+"发生变化");
		System.out.println("1作出回应");
	}
}
class Observer2 implements Observer{
	public void update(Observable o) {
		System.out.println("观察2：观察到"+o.getClass().getSimpleName()+"发生变化");
		System.out.println("2作出回应");
	}
}
//被观察者类
class Observable{
	List<Observer> oList=new ArrayList<Observer>();			
	public void addObserver(Observer observer){
		if(!oList.contains(observer)){
			oList.add(observer);
		}
	}
	
	public void change(){
		System.out.println("我是被观察者，已发生变化");
		notifyObservers();
	}
	//notifyObservers方法通知这些类
	public void notifyObservers(){
		for(Observer observer:oList){
			observer.update(this);
		}
	}
}
public class A_simpleExemple {
	public static void main(String[] args) {
		Observable oa=new Observable();
		oa.addObserver(new Observer1());
		oa.addObserver(new Observer2());
		oa.change();
	}
}



package ljtao.pattern.k_facade;
interface Sub1{
	void function1();
}
interface Sub2{
	void function2();
}
interface Sub3{
	void function3();
}
class Sub1Impl implements Sub1{
	public void function1() {
		System.out.println("子系统中Sub1接口功能");
	}
}
class Sub2Impl implements Sub2{
	public void function2() {
		System.out.println("子系统中Sub2接口功能");
	}
}
class Sub3Impl implements Sub3{
	public void function3() {
		System.out.println("子系统中Sub3接口功能");
	}
}
//以上模拟一个子系统模型

interface Faceade{
	void function12();
	void function23();
	void function123();
} 
class FaceadeImpl implements Faceade{
	private Sub1 sub1;
	private Sub2 sub2;
	private Sub3 sub3;
	FaceadeImpl(){
		super();
		sub1=new Sub1Impl();
		sub2=new Sub2Impl();
		sub3=new Sub3Impl();
	}
	FaceadeImpl(Sub1 sub1,Sub2 sub2,Sub3 sub3){
		super();
		this.sub1= sub1;
		this.sub2= sub2;
		this.sub3= sub3;
	}
	@Override
	public void function12() {
		sub1.function1();
		sub2.function2();
	}

	@Override
	public void function23() {
		sub2.function2();
		sub3.function3();
		
	}
	@Override
	public void function123() {
		sub1.function1();
		sub2.function2();
		sub3.function3();
	}
}
//以上便是外观接口和实现类，它当中的功能一般是根据是客户端的需要定制的，将客户端的一个完整功能作为一个行为，然后调用子系统完成。
public class Client {
	public static void main(String[] args){
		FaceadeImpl f=new FaceadeImpl();
		f.function12();
		f.function123();
		f.function23();
		System.out.println("-----原始方式---------");
		Sub1Impl s1=new Sub1Impl();
		Sub2Impl s2=new Sub2Impl();
		Sub3Impl s3=new Sub3Impl();
		s1.function1();
		s2.function2();
		s1.function1();
		s2.function2();
		s3.function3();
		s1.function1();
		s2.function2();
		s3.function3();
	}
}

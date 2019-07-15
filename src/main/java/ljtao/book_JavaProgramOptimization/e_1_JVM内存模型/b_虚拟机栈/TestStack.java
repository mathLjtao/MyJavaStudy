package ljtao.book_JavaProgramOptimization.e_1_JVM内存模型.b_虚拟机栈;

public class TestStack {
	public static void main(String[] args) {
		new TestStack().demo3();
	}
	private int count=0;
	public void demo1(){
		count++;
		demo1();
	}
	public void demo2(long a,long b,long c){
		long d=0,e=0,f=0;
		double g=9;
		count++;
		demo2(a,b,c);
	}
	public void demo3(){
		try {
			//demo1();//count=11422,就报错了
			demo2(1l,2l,3l);//count=5020，就报错了 ，方法里面有局部变量、函数参数什么的，栈的上限就会变小了
		} catch (Throwable e) {
			System.out.println("max:"+count);
			e.printStackTrace();
	
		}
	}
}

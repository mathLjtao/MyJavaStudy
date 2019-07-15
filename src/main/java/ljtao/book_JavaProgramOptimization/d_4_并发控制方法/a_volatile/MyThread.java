package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.a_volatile;
/*
 * 声明为volatile的变量可以做以下保证
 * 1、其他线程对变量的修改，可以即时反应在当前线程中
 * 2、确保当前线程对volatile变量的修改，能即时写会共享主内存中，并被其他线程所见
 * 3、使用volatile 声明的变量，编译器会保证其有序性
 */
public class MyThread implements Runnable{
	private volatile boolean stop=false;
	public void stop(){
		stop=true;
	}
	@Override
	public void run() {
		while(!stop){
			System.out.print("1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package ljtao.book_JavaProgramOptimization.d_2.a_threadpool;

public class MyThread implements Runnable{
	protected String name;
	public MyThread(){
		
	}
	public MyThread(String name){
		this.name=name;
	}
	@Override
	public void run() {
		try {
			System.out.print("?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

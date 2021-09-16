package ljtao.book_JavaProgramOptimization.d_2.b_自定义线程池;

public class MyThread implements Runnable ,Comparable<MyThread>{
	protected String name;
	private volatile int i=5;
	public MyThread(){}
	public MyThread(String name){
		this.name=name;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(name+" ");
			while (i!=0){
				System.out.println(i);
				i--;
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int compareTo(MyThread o) {
		int me=Integer.parseInt(this.name.split("_")[1]);
		int other=Integer.parseInt(o.name.split("_")[1]);
		System.out.println(me+"---"+other);
		return me-other;
	}
}

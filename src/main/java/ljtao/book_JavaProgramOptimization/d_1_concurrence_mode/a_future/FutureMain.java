package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.a_future;
/*
 * 这个模式就是，先告知client已经接受它的请求了，然后另外 一边在处理它的请求，处理完它的请求后，它就可以获取它想要的数据了.
 * future模式的好处，在于去除主函数中的等待时间，并使得原本需要等待的时间段可以用于处理其他的业务逻辑，
 */
public class FutureMain {
	public static void main(String[] args) {
		Client client=new Client();
		Data data=client.request("name");
		System.out.println("请求完毕");
		System.out.println("数据="+data.getResult());
		try {
			//业务逻辑处理模拟
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("数据="+data.getResult());
	}
}

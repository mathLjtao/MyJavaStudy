package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.a_future;
//返回Data对象，立即返回futureData，并开启ClientThread线程装配RealData
public class Client {

	public Data request(final String queryStr) {
		final FutureData future=new FutureData();
		new Thread(){
			public void run(){
				//对真实的数据处理
				RealData realdata=new RealData(queryStr);
				future.setRealData(realdata);
			}
		}.start();
		return future;
	}
}

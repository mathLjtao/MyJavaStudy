package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.a_future;
//真实数据，构造比较慢
public class RealData implements Data {

	protected final String result;

	public RealData(String para) {
		//RealData的构造可能很慢，需要用户等待很久，这里用sleep模拟
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		result=sb.toString();
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}

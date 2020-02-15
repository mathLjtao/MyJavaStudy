package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.b_jdk_future;

import java.util.concurrent.Callable;

public class RealData implements Callable<String>{
	private String para;
	public RealData(String para){
		this.para=para;
	}
	@Override
	public String call() throws Exception {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}
		}
		return sb.toString();
	}

}

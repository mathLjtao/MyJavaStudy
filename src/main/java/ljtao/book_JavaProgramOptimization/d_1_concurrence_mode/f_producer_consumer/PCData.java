package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.f_producer_consumer;
//作为生产者和消费者之间的共享数据模型
public class PCData {
	private final int intData;
	
	public PCData(int d) {
		intData=d;
	}
	public PCData(String d) {
		intData=Integer.valueOf(d);
	}
	public int getData() {
		return intData;
	}
	public String toString(){
		return "data:"+intData;
	}

}

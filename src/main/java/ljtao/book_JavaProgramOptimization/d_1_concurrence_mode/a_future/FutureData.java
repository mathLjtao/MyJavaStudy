package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.a_future;
//future数据，构造很快，但是是一个虚拟的数据，需要装配RealData数据
public class FutureData implements Data {
	//FutureData是RealData的包装
	protected RealData realdata=null;
	protected boolean isReady=false;
	public synchronized void setRealData(RealData realdata) {
		// TODO Auto-generated method stub
		if(isReady)
			return ;
		this.realdata=realdata;
		isReady=true;
		notifyAll();
	}
	

	@Override
	public synchronized String getResult() {
		// TODO Auto-generated method stub
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realdata.result;
	}

}

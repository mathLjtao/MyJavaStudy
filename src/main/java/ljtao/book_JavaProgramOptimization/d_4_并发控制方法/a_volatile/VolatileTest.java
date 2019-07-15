package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.a_volatile;

public class VolatileTest {
	public volatile boolean isExit;
	//public boolean isExit;
	public void tryExit(){
		
		if(isExit==!isExit){
			System.out.println("stop Thread");
			System.exit(0);
		}
	}
	public void swapValue(){
		isExit=!isExit;
	}
	public void test() throws Exception
	{
		final VolatileTest vol=new VolatileTest();
		Thread t1=new Thread(){
			
			public void run(){
				System.out.println("tryExit");
				while(true){
					//不停尝试推出
					vol.tryExit();
				}
			}
		};
		t1.start();
		Thread t2=new Thread(){
			
			public void run(){
				while(true){
					//不停更换值
					System.out.println("swapValue");
					vol.swapValue();
				}
			}
		};
		t2.start();
		Thread.sleep(10000);
	}
	
}

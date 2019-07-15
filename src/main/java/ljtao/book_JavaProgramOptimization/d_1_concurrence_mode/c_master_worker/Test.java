package ljtao.book_JavaProgramOptimization.d_1_concurrence_mode.c_master_worker;

import java.util.Map;
import java.util.Set;

//测试master-worker模式
public class Test {
	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		demo1();
		System.out.println(System.currentTimeMillis()-currentTimeMillis);
	}
	//测试1*1*1 +。。。--- 100*100*100
	public static void demo1(){
		Master master=new Master(new Worker(),15);
		for(int i=1;i<101;i++){
			master.submit(i);
		}
		master.execute();
		int re=0;
		Map<String, Object> resultMap = master.getResult();
		//结果集所有数据处理完，跟5个活跃的线程全部终止，才给出最终结果
		while(resultMap.size()>0 || !master.isComplete()){
			Set<String> keySet = resultMap.keySet();
			/**/
			for(String key:keySet){
				re+=(int)resultMap.get(key);
				resultMap.remove(key);
			}
			
			/*书本的做法
			String k=null;
			for(String key:keySet){
				k=key;
				break;
			}
			Integer i=null;
			if(k!=null){
				i=(Integer)resultMap.get(k);
				resultMap.remove(k);//移除
			}
			if(i!=null){
				re+=(int)i;
			}
			*/
		}
		System.out.println(re);
		
	}
}

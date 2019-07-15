package ljtao.pattern.f_observer.A_simulationWriterAndReader;

import java.util.HashMap;
import java.util.Map;

//管理器，保持一份独有的作者列表
public class WriterManager {
	private Map<String,Writer> writerMap=new HashMap<String,Writer>();
	//添加作者
	public void addWriter(Writer writer){
		writerMap.put(writer.getName(), writer);
	}
	//根据作者姓名获取作者
	public Writer getWriter(String name){
		return writerMap.get(name);
	}
	//单例
	private WriterManager(){}
	private static class WriterManagerInner{
		private static WriterManager writerManager= new WriterManager();
	}
	public static WriterManager getWriterManager(){
		return WriterManagerInner.writerManager;
	}
}

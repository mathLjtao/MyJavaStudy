package ljtao.pattern.f_observer.A_simulationWriterAndReader;

import java.util.Observable;
import java.util.Observer;
//实现观察者接口，用JDK中的观察者模式设计
public class Reader implements Observer {
	private String name;
	public Reader(String name){
		super();
		this.name=name;
	}
	public String getName(){
		return name;
	}
	//读者可以关注某一位作者，关注则代表把自己加到作者的观察者列表里
	public void subscribe(String writerName){
		WriterManager.getWriterManager().getWriter(writerName).addObserver(this);
	}
	//读者可以取消关注某一位作者，取消关注则代表把自己从作者的观察者列表里删除
	public void unsubscribe(String writerName){
		WriterManager.getWriterManager().getWriter(writerName).deleteObserver(this);
	}
	//当关注的作者发表新小说时，会通知读者去看
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Writer){
			Writer writer=(Writer)o;
			System.out.println(name+"知道了"+writer.getName()+"发不了新书《"+writer.getLastNovel()+"》");
		}
		
	}
}

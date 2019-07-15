package ljtao.pattern.f_observer.A_simulationWriterAndReader;

import java.util.Observable;

public class Writer extends Observable{
	private String name;
	private String lastNovel;//作者最近发布的小说
	public Writer(String name){
		super();
		this.name=name;
		WriterManager.getWriterManager().addWriter(this);
	}
	//作者发布新小说了，要通知所有关注自己的读者
	public void addNovel(String novelName){
		System.out.println(name+"，发布了新书："+novelName);
		lastNovel=novelName;
		setChanged();//设置已经改变的标识
		notifyObservers();//通知方法
	}
	public String getName(){
		return name;
	}
	public String getLastNovel(){
		return lastNovel;
	}
	
}

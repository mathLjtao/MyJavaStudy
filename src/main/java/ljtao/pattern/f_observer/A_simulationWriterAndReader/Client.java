package ljtao.pattern.f_observer.A_simulationWriterAndReader;

/*
 * 这个客户端程序是验证 ，用jdk的观察者模式来实现一个阅读者订阅作者，作者出书后中会通知阅读者的一个过程
 */
public class Client {
	
	public static void main(String[] args) {
		Reader r1=new Reader("张三");
		Reader r2=new Reader("李四");
		
		Writer w1=new Writer("李白");
		w1.addNovel("李1");w1.addNovel("李2");
		Writer w2=new Writer("杜甫");
		w2.addNovel("杜1");
		
		r1.subscribe("李白");
		r1.subscribe("杜甫");
		r2.subscribe("李白");
		
		w1.addNovel("李3");
		w2.addNovel("杜2");
		r1.unsubscribe("李白");//取消关注
		w1.addNovel("李4");
	}

}

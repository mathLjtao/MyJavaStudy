package ljtao.pattern.m_proxy.staticproxy;

public class ProxySubject extends Subject{
	private RealSubject realSubject;
	public ProxySubject(){}
	
	@Override
	public void request() {
		preRequest();
		if(realSubject==null){
			realSubject=new RealSubject();
		}
		realSubject.request();
		posRequest();
	}
	public void preRequest(){
		System.out.println("请求前");
	}
	public void posRequest(){
		System.out.println("请求后");
	}
}
